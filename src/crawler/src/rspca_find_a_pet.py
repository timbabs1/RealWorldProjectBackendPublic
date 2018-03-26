import requests
import re
import json
import bs4

def lookup_postcode(postcode):
    r = requests.get("https://api.postcodes.io/postcodes/{}".format(postcode))
    data = r.json()
    if data['status'] != 200:
        return None
    return (data['result']['longitude'], data['result']['latitude'])

class RSPCAFindAPet:
    def __init__(self, host="https://www.rspca.org.uk"):
        self._host = host
    # Generate URLs for us.
    def _url(self, endpoint):
        return "{}/{}".format(self._host, endpoint)
    # Preform the search.
    def search(self, location):
        # Default parameters from the site.
        params = {
            "p_p_id":"petSearch2016_WAR_ptlPetRehomingPortlets",
            "p_p_lifecycle":1,
            "p_p_state":"normal",
            "p_p_mode":"view",
            "p_p_col_id":"column-2",
            "p_p_col_count":2,
            "_petSearch2016_WAR_ptlPetRehomingPortlets_action":"search"
        }
        long, lat = lookup_postcode(location)
        # What we need to preform a search.
        data = {
            "noPageView":False,
            "animalType":"CAT",
            "freshSearch":False,
            "arrivalSort":False,
            "previousAnimalType":"CAT",
            "location":location,
            "postcode":location,
            "searchedLongitude":long,
            "searchedLatitude":lat
        }
        # Send off the request.
        r = requests.post(self._url('findapet'),
                          params=params,
                          data=data)
        # Now go extract each animals URL from the site.
        compiled = re.compile(
            "/findapet/details/-/Animal/.{1,32}/ref/BSA[0-9]{1,20}/rehome")
        lines = r.text.split("\n")
        urls = []
        for line in lines:
            searched = compiled.findall(line)
            if searched != None:
                for item in searched: urls.append(item)
        return urls
    def examine(self, url):
        r = requests.get(self._url(url))
        # Extract what we want from the document
        document = bs4.BeautifulSoup(r.text, "lxml")
        # Name of animal
        name = document.title.string.split(' -')[0]
        # Description of the Animal
        description = document.find("div", {"class":"petDescription"})\
            .get_text().strip()
        # Get what the cats is suitable for
        try:
            misc_details = []
            misc = document.find("div", {"id": "lifeStyle"})
            misc_details =  map(lambda x: x.get_text(), misc.find("ul")\
                               .findAll("li"))
        except:
            pass
        # The Animals picture
        image = document.find("img", {"id": "largeImage"})['src']
        # Details like age, etc.
        properties = {}
        for row in document.find("div", {"class": "aboutMe"}).findAll("tr"):
            properties[row.find("th").get_text()[:-1].lower()] = \
                row.find("td").get_text().replace('\n','').replace('\t','')\
                .replace('\r','')
        # Shelters Information
        try:
            shelter_name = ""
            shelter_email = ""
            shelter_hours = ""
            shelter = document.find('div', {'class': 'establishmentDetails'})
            shelter_name = shelter.find('a', {'id': 'trackingEstabMoreInfo'})\
                .get_text()
            shelter_email = shelter.find('div', {'class':'contact'}).get_text()\
                .strip()
            shelter_hours = shelter.find('div',\
                {'class':'establishmentOpeningHours'}).get_text().strip()
        except:
            pass
        return {
            'name':name,
            'description':description,
            'properties':properties,
            'misc':misc_details,
            'image':self._url(image),
            'shelter':{
                'name': shelter_name,
                'email':shelter_email,
                'hours':shelter_hours
            }
        }

if __name__ == "__main__":
    finder = RSPCAFindAPet()
    animals = finder.search("CV13AQ")
    for i in animals:
        print(finder.examine(i))
