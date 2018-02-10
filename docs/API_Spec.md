# API Spec

## General

### Authentication

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

### Errors

The standard errors are:
* Unauthorized - You haven't logged in.

## Endpoints

### `GET /recomended`

This will return a list of Animals reconmened for a the user.

#### Example
```json
{
  "animals":[
    {
      "id":"RANDOMID",
      "name":"NAME",
      "type":"DOG",
      "desc":"This is a dog.",
      "location":{
        "postcode":"BLAH"
      }
    }
  ]
}
```

#### Errors

Nothing beyond the standard errors.
