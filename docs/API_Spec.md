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

## Permissions

Each key has permisions detailing what resources it can access.

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
  "desc":"Description of Shelter",
  "animals":[
    //<list of animal ids>
  ]
}
```

## Endpoints

### `GET /animals/<ID>`

Return an animal based on it's id.

### `POST /animals/`

This will return a list of `Animals` for a the user.

#### Options

* Location
* Count
* Properties (A list of the ones you are looking for)

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

Add a new shelter.

#### Permisions

* CREATE_SHELTER

### `POST /animals/add`

Add a new animal.

#### Permisions

* SHELTER

### `GET /animals/<id>`

Get the details on the animal.

### `POST /user/fav`

Favorite an animal so the user can track their status / keep aware of it for later.

### `GET /user/recomended`

Get a list of `Animal`s recommend by the user.

### `POST /user/auth`

Takes the users login details and returns a token if they are correct.

#### Input

```
{
  "username":"<USERNAME>",
  "password":"<PASSWORD>"
}
```

#### Return

Success:
```
{
  "status":"OK"
}
```
Error:
```
{
  "status":"FAILURE",
  "error":"Unable to Autheticate"
}  
```
