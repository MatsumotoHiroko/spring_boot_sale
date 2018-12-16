# Spring Boot Sample Sale API
It's an imaginary "sales" platform.

# environment
## running docker compose
[instration docker compose](https://docs.docker.com/compose/install/)
```
$ docker-compose up
```

## requirement
#### JDK 1.8
[download](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
#### MongoDB
[instration manual](https://docs.mongodb.com/manual/installation/)

# parameter
## columns
| key | data type | validation |
|---|---|---|
| title | string | not blank, character length 1 <= 30 |
| description | string | character length 1 <= 100 |
| price | int | not null |
| stock | int | not null |
| country | string | character length 0 <= 20 |
| state | string | character length 0 <= 100 |
| city | string | character length 0 <= 100 |
| street | string | character length 0 <= 100 |
| latitude | double | not null |
| longitude | double | not null |

## search

| key | search target | search parameter | description |
|---|---|---|---|
| findByTitle | title | name="sample" | … where x.title = ?1 |
| findByCountry | country | name="sample" | … where x.country = ?1 |
| findByState | state | name="sample" | … where x.country = ?1 |
| findByCity | city | name="sample" | … where x.city = ?1 |
| findByDescriptionLike | description | name="sample" | … where x.description like ?1 |
| findByStreetLike | street | name="sample" | … where x.state like ?1 |
| findAllByOrderByPriceAsc | price | none | … order by x.price asc |
| findAllByOrderByPriceDesc | price | none | … order by x.price desc |
| findAllByOrderByStockAsc | stock | none | … order by x.stock asc |
| findAllByOrderByStockDesc | stock | none | … order by x.stock desc |
| findByPriceBetween | price | grater=1&less=100 | … where x.price between ?1 and ?2 |
| findByStockBetween | stock | grater=1&less=100 | … where x.stock between ?1 and ?2 |

# Test the application
## POST (data input)
```
$ curl -i -X POST -H "Content-Type:application/json" -d "{  \"title\" : \"testitem1\",  \"description\" : \"test description\", \"price\" : \"100\", \"stock\" : \"50\", \"country\" : \"Japan\", \"state\" : \"Tokyo\", \"city\" : \"Chiyoda\", \"street\" : \"1-7-1 Nagata\", \"latitude\" : \"35.67571\", \"longitude\" : \"139.74481\" }" http://localhost:8080/sale

Location: http://localhost:8080/sale/5c15cabb9eb8140bd630eb75
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Sun, 16 Dec 2018 03:47:07 GMT
```

## PATCH (data update)
```
curl -X PATCH -H "Content-Type:application/json" -d "{ \"title\": \"title2\" }" http://localhost:8080/sale/5c15cabb9eb8140bd630eb75
```

## DELETE (data remove)
```
curl -X DELETE http://localhost:8080/sale/5c15cabb9eb8140bd630eb75

```

## GET (data search)
### getting all data 
```
$ curl http://localhost:8080/sale

{
  "_embedded" : {
    "sale" : [ {
      {
      "title" : "testitem1",
      "description" : "test description",
      "price" : 100,
      "stock" : 50,
      "country" : "Japan",
      "state" : "Tokyo",
      "city" : "Chiyoda",
      "street" : "1-7-1 Nagata",
      "latitude" : 35.67571,
      "longitude" : 139.74481,
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/sale/5c15cabb9eb8140bd630eb75"
        },
        "sale" : {
          "href" : "http://localhost:8080/sale/5c15cabb9eb8140bd630eb75"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/sale{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/sale"
    },
    "search" : {
      "href" : "http://localhost:8080/sale/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 1,
    "totalPages" : 1,
    "number" : 0
  }
```

### getting specific data (using search action)
```
$ curl http://localhost:8080/sale/search/findByTitle?name=testitem1
$ curl http://localhost:8080/sale/search/findByStreetLike?name=Nagata
$ curl http://localhost:8080/sale/search/findAllByOrderByPriceAsc
$ curl http://localhost:8080/sale/search/findByStockBetween?grater=50\&less=200
```
