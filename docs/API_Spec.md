# API Spec

## General

### Authentication

Not yet decided, but will most likely involve sending the username + password encrypted to a endpoint and then returning a cookie.

### IDs

IDs are random 16 byte base64 encoded strings.

### Locations

As the location details we have on an animal can vary, locations can have any of of the following (including a mix and match):
* postcode
* gps (For Longitude/Latitude)
* town
* county
* country

They are stored as a JSON object.

## Properties

Mainly searchable traits of the animal, e.g the ones listed on the RSPCA website.

## Contact

Object to describe basic shelter information.

### Errors

The standard errors are:
* Unauthorized - You haven't logged in.

## Objects

Objects applications need to understand.

### Animals

#### Example

```json
{
  "id":"RANDOMID",
  "name":"NAME",
  "type":"DOG",
  "desc":"This is a dog.",
  "status":"Avaliable",
  "location":{
    "postcode":"BLAH"
  },
  "properties":{
    //<defined above>
  },
  "shelter":"SHELTERID"
}
```

### Shelters

```json
{
  "id":"RANDOMID",
  "name":"Shelter Name",
  "contact":{
    //<defined above>
  },
  "desc":"Description of Shelter"
  "animals":[
    //<list of animal ids>
  ]
}
```

## Endpoints

### `GET /animals/search`

This will return a list of `Animals` recomended for a the user.

#### Options

* Location
* Count
* 

#### Example

```json
{
  "count": 1,
  "animals":[
    {
      "id":"RANDOMID",
      "name":"NAME",
      "type":"DOG",
      "desc":"This is a dog.",
      "status":"Avaliable",
      "location":{
        "postcode":"BLAH"
      },
      "properties":{    
      },
      "shelter":"SHELTERID"
    }
  ]
}
```

#### Errors

Nothing beyond the standard errors.

### `POST /shelter/add`

Add a new shelter. Requires an Key with CREATE_SHELTER permissions.

### `POST /animals/add`

Add a new animal. Requires a SHELTER permission.

### `POST /user/fav`

Favorite an animal so the user can track their status / keep aware of it for later.
