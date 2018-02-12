import requests
import re
import json

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

if __name__ == "__main__":
    finder = RSPCAFindAPet()
    print(finder.search("CV13AQ"))
