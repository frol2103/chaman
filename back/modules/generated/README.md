# Chaman

No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)


## API

### Annex

|Name|Role|
|----|----|
|`be.frol.chaman.openapi.api.AnnexController`|Play Framework API controller|
|`be.frol.chaman.openapi.api.AnnexApi`|Representing trait|

* `DELETE /api/annex/:uuid` - delete an annex
* `POST /api/item/:uuid/annex` - upload a file

### Datatypes

|Name|Role|
|----|----|
|`be.frol.chaman.openapi.api.DatatypesController`|Play Framework API controller|
|`be.frol.chaman.openapi.api.DatatypesApi`|Representing trait|

* `GET /api/data-types/` - get data type

### Event

|Name|Role|
|----|----|
|`be.frol.chaman.openapi.api.EventController`|Play Framework API controller|
|`be.frol.chaman.openapi.api.EventApi`|Representing trait|

* `PUT /api/event` - add an event

### Field

|Name|Role|
|----|----|
|`be.frol.chaman.openapi.api.FieldController`|Play Framework API controller|
|`be.frol.chaman.openapi.api.FieldApi`|Representing trait|

* `POST /api/field` - create a field
* `DELETE /api/field/:uuid` - delete a field
* `GET /api/field` - Get a field
* `GET /api/field/:uuid` - get a field config
* `PUT /api/field/:uuid` - update a field

### File

|Name|Role|
|----|----|
|`be.frol.chaman.openapi.api.FileController`|Play Framework API controller|
|`be.frol.chaman.openapi.api.FileApi`|Representing trait|

* `GET /api/annex/:uuid/file` - get a file
* `GET /api/item/:uuid/thumbnail/file` - get a thumbnail file

### Item

|Name|Role|
|----|----|
|`be.frol.chaman.openapi.api.ItemController`|Play Framework API controller|
|`be.frol.chaman.openapi.api.ItemApi`|Representing trait|

* `POST /api/item` - create an item
* `DELETE /api/item/:uuid` - delete a item
* `DELETE /api/item/:uuid/field/:uuidField` - delete an item field
* `GET /api/item/:uuid` - get a item
* `GET /api/item` - Get all items
* `PUT /api/item/:uuid/field/:uuidField?subReferenceUuid=[value]` - update an item field

### Link

|Name|Role|
|----|----|
|`be.frol.chaman.openapi.api.LinkController`|Play Framework API controller|
|`be.frol.chaman.openapi.api.LinkApi`|Representing trait|

* `POST /api/item/:uuid/link?linkedUuid=[value]` - add a link
* `DELETE /api/link/:uuid` - delete a link

### Tag

|Name|Role|
|----|----|
|`be.frol.chaman.openapi.api.TagController`|Play Framework API controller|
|`be.frol.chaman.openapi.api.TagApi`|Representing trait|

* `PUT /api/field/:uuid/tag?value=[value]` - add tag for a field
* `GET /api/field/:uuid/tag` - get tag list for a field

### Thumbnail

|Name|Role|
|----|----|
|`be.frol.chaman.openapi.api.ThumbnailController`|Play Framework API controller|
|`be.frol.chaman.openapi.api.ThumbnailApi`|Representing trait|

* `GET /api/item/:uuid/thumbnail` - get thumbnail description
* `PUT /api/item/:uuid/thumbnail` - set thumbnail description

