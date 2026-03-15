Sovellus on tarkoitettu verkkokaupan ylläpitäjille.
Sovellus käyttää Spring Web- ja Spring Data JPA -kirjastoja.

Tietokannassa on toteutettu tapahtuma mikä tarkistaa joka päivä tuotteiden varastosaldoa. Jos saldo on 0, niin tuote lisätään "outofstock" tauluun. Tämän taulun on helppo siivota käyttämällä endpointtia. Tämä endpointti on toteutettu massaoperaatiota käyttäen.

Tietokantaan on myös toteutettu liipaisin joka lisää "orderlog" tauluun lokitietoja uusista tilauksista.
Tietokannan käyttäjiä on luotu rajaamaan oikeuksia. Varmuuskopiointisuunnitelma sekä toimintasuunnitelma on tehty.

Projekti on toteutettu aika pitkälti tunneilla käydyn tehtävien perusteella. Ainoa asia minkä olen muuttanut olen poistanut "contact_info" taulun kokonaan. Eli asiakkaan ja toimittajan tiedot tulee hankkia customer ja suppliers taulujen kautta. Tämä customer_info taulu luotiin oppimispäiväkirja nro 12:ssa. Muuten tietokanta on täysin sama. 

Käytettävissä olevat endpointit:

## Tuote (`/product`)
| Metodi | Polku            | Kuvaus                     |
|--------|-----------------------|----------------------------|
| GET    | /product              | Näytä kaikki tuotteet      |
| GET    | /product/{id}         | Hae tuote ID:n perusteella |
| POST   | /product              | Lisää uusi tuote           |
| PUT    | /product/{id}         | Päivitä tuote ID:n avulla  |
| DELETE | /product/{id}         | Poists tuote ID:n avulla   |

---
## Varasto loppu (OutOfStock) (`/outofstock`)
| Metodi | Polku                | Kuvaus                                      |
|--------|----------------------|---------------------------------------------|
| DELETE | /outofstock/cleanup  | Siivoa OutOfStock-taulu (poistaa saatavilla olevat tuotteet) |
| GET | /outofstock | Hae kaikki tuotteet joiden varastosaldo on 0 |

---

## Tilaus (`/order`)
| Methodi | Polku                     | Kuvaus                             |
|--------|---------------------------------|------------------------------------|
| GET    | /order/                         | Näytä kaikki tilaukset             |
| GET    | /order/{id}                     | Hae tilaus ID:n perusteella        |
| POST   | /order                    | Luo uusi tilaus                    |
| PUT    | /order/{id}                     | Päivitä tilaus ID:n avulla         |
| DELETE | /order/{id}                     | Poista tilaus ID:n avulla          |
| GET    | /order/by-customer/{customerId} | Hae tilaukset asiakkaan ID:n avulla|
| DELETE | /order/clearcancelled           | Poista kaikki peruutetut tilaukset |
| PATCH  | /order/{id}/status              | Päivitä tilauksen status tilaa     |
---
## Tilauslokit (`/orderlogs`)
| Metodi | Polku                           | Kuvaus                          |
|--------|----------------------------------|---------------------------------|
| GET    | /orderlogs                       | Listaa kaikki tilauslokit       |
| GET    | /orderlogs/{id}                  | Hae lokimerkintä ID:llä         |
| GET    | /orderlogs/by-order/{orderId}    | Hae lokit tilauksen ID:llä      |
| GET    | /orderlogs/by-customer/{customerId} | Hae lokit asiakkaan ID:llä   |
  
---
## Asiakas (`/customer`)
| Metodi | Polku                | Kuvaus                              |
|--------|----------------------|-------------------------------------|
| GET    | /customer            | Listaa kaikki asiakkaat             |
| GET    | /customer/{id}       | Hae asiakas ID:llä                  |
| POST   | /customer            | Luo asiakas ja osoite               |
| PUT    | /customer/{id}       | Päivitä asiakas ID:llä              |
| DELETE | /customer/{id}       | Poista asiakas ID:llä               |

---

## Asiakasosoitteet (`/customeraddresses`)
| Metodi | Polku                                         | Kuvaus                              |
|--------|-----------------------------------------------|-------------------------------------|
| POST   | /customeraddresses                            | Luo osoite asiakkaalle              |
| PUT    | /customeraddresses/{id}                       | Päivitä osoite osoitteen ID:llä     |
| DELETE | /customeraddresses/{id}                       | Poista osoite osoitteen ID:llä      |
| GET    | /customeraddresses/{id}                       | Hae osoite osoitteen ID:llä         |
| GET    | /customeraddresses/by-customer/{customerId}   | Hae osoite asiakkaan ID:llä         |
| PUT    | /customeraddresses/by-customer/{customerId}   | Päivitä osoite asiakkaan ID:llä     |

---
## Toimittajaosoitteet (`/supplieraddresses`)
| Metodi | Polku                                           | Kuvaus                                |
|--------|--------------------------------------------------|---------------------------------------|
| GET    | /supplieraddresses/                              | Listaa kaikki toimittajaosoitteet     |
| GET    | /supplieraddresses/{id}                          | Hae toimittajaosoite ID:llä           |
| POST   | /supplieraddresses                               | Luo osoite toimittajalle              |
| GET    | /supplieraddresses/by-supplier/{supplierId}      | Hae osoite toimittajan ID:llä         |
| PUT    | /supplieraddresses/by-supplier/{supplierId}      | Päivitä osoite toimittajan ID:llä     |
---
## Toimittaja (`/supplier`)
| Metodi | Polku                | Kuvaus                              |
|--------|----------------------|-------------------------------------|
| GET    | /supplier            | Listaa kaikki toimittajat           |
| GET    | /supplier/{id}       | Hae toimittaja ID:llä               |
| POST   | /supplier            | Luo toimittaja ja osoite            |


### Esimerkkejä JSON-pyynnöistä ja -vastauksista

## Product

### GET /product

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
[
  {
    "id": 1,
    "name": "Puhelin",
    "description": "Älypuhelin",
    "price": 499.99,
    "stock_quantity": 10,
    "category_id": 2,
    "supplier_id": 1
  }
]
```
### POST /product

**Pyyntö:**
```json
{
  "name": "Puhelin",
  "description": "Älypuhelin",
  "price": 499.99,
  "stock_quantity": 10,
  "category_id": 2,
  "supplier_id": 1
}
```
**Vastaus:**
```json
{
  "id": 1,
  "name": "Puhelin",
  "description": "Älypuhelin",
  "price": 499.99,
  "stock_quantity": 10,
  "category_id": 2,
  "supplier_id": 1
}
```

### PUT /product/{id}

**Pyyntö:**
```json
{
  "name": "Puhelin Pro",
  "description": "Päivitetty malli",
  "price": 599.99,
  "stock_quantity": 8,
  "category_id": 2,
  "supplier_id": 1
}
```
**Vastaus:**
```json
{
  "id": 1,
  "name": "Puhelin Pro",
  "description": "Päivitetty malli",
  "price": 599.99,
  "stock_quantity": 8,
  "category_id": 2,
  "supplier_id": 1
}
```
## Tilaus

### GET /order/

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
[
  {
    "id": 1,
    "customerId": 1,
    "orderDate": "2026-03-15T12:00:00",
    "deliveryDate": "2026-03-18T12:00:00",
    "shippingAddressId": 1,
    "status": "NEW"
  }
]
```

### GET /order/{id}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
{
  "id": 1,
  "customerId": 1,
  "orderDate": "2026-03-15T12:00:00",
  "deliveryDate": "2026-03-18T12:00:00",
  "shippingAddressId": 1,
  "status": "NEW"
}
```

### POST /order

**Pyyntö:**
```json
{
  "customerId": 1,
  "orderDate": "2026-03-15T12:00:00",
  "deliveryDate": "2026-03-18T12:00:00",
  "shippingAddressId": 1,
  "status": "NEW"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "customerId": 1,
  "orderDate": "2026-03-15T12:00:00",
  "deliveryDate": "2026-03-18T12:00:00",
  "shippingAddressId": 1,
  "status": "NEW"
}
```

### PUT /order/{id}

**Pyyntö:**
```json
{
  "customerId": 1,
  "orderDate": "2026-03-15T12:00:00",
  "deliveryDate": "2026-03-20T12:00:00",
  "shippingAddressId": 1,
  "status": "PROCESSING"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "customerId": 1,
  "orderDate": "2026-03-15T12:00:00",
  "deliveryDate": "2026-03-20T12:00:00",
  "shippingAddressId": 1,
  "status": "PROCESSING"
}
```

### PATCH /order/{id}/status

**Pyyntö:**
```json
{
  "status": "CANCELLED"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "customerId": 1,
  "orderDate": "2026-03-15T12:00:00",
  "deliveryDate": "2026-03-20T12:00:00",
  "shippingAddressId": 1,
  "status": "CANCELLED"
}
```

### GET /order/by-customer/{customerId}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
[
  {
    "id": 1,
    "customerId": 1,
    "orderDate": "2026-03-15T12:00:00",
    "deliveryDate": "2026-03-18T12:00:00",
    "shippingAddressId": 1,
    "status": "NEW"
  }
]
```

### DELETE /order/{id}

**Pyyntö:**
```json
{}
```


### DELETE /order/clearcancelled

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
"1 cancelled orders deleted, 2 order items deleted"
```


## Asiakas

### GET /customer

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
[
  {
    "id": 1,
    "phone": "0401234567",
    "email": "matti.meikalainen@example.com",
    "first_name": "Matti",
    "last_name": "Meikäläinen"
  }
]
```

### GET /customer/{id}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
{
  "id": 1,
  "phone": "0401234567",
  "email": "matti.meikalainen@example.com",
  "first_name": "Matti",
  "last_name": "Meikäläinen"
}
```

### POST /customer

**Pyyntö:**
```json
{
  "firstName": "Matti",
  "lastName": "Meikäläinen",
  "phone": "0401234567",
  "email": "matti.meikalainen@example.com",
  "streetAddress": "Katu 1",
  "postalCode": "00100",
  "city": "Helsinki",
  "country": "Suomi"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "first_name": "Matti",
  "last_name": "Meikäläinen",
  "phone": "0401234567",
  "email": "matti.meikalainen@example.com"
}
```

### PUT /customer/{id}

**Pyyntö:**
```json
{
  "first_name": "Matti",
  "last_name": "Meikäläinen",
  "phone": "0407654321",
  "email": "matti.uusi@example.com"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "first_name": "Matti",
  "last_name": "Meikäläinen",
  "phone": "0407654321",
  "email": "matti.uusi@example.com"
}
```

### DELETE /customer/{id}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
{}
```

## Asiakasosoitteet

### POST /customeraddresses?customerId={customerId}

**Pyyntö:**
```json
{
  "streetAddress": "Katu 1",
  "postalCode": "00100",
  "city": "Helsinki",
  "country": "Suomi"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "street_address": "Katu 1",
  "postal_code": "00100",
  "city": "Helsinki",
  "country": "Suomi"
}
```

### GET /customeraddresses/{id}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
{
  "id": 1,
  "street_address": "Katu 1",
  "postal_code": "00100",
  "city": "Helsinki",
  "country": "Suomi"
}
```

### GET /customeraddresses/by-customer/{customerId}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
{
  "id": 1,
  "street_address": "Katu 1",
  "postal_code": "00100",
  "city": "Helsinki",
  "country": "Suomi"
}
```

### PUT /customeraddresses/{id}

**Pyyntö:**
```json
{
  "streetAddress": "Katu 2",
  "postalCode": "00100",
  "city": "Helsinki",
  "country": "Suomi"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "street_address": "Katu 2",
  "postal_code": "00100",
  "city": "Helsinki",
  "country": "Suomi"
}
```

### PUT /customeraddresses/by-customer/{customerId}

**Pyyntö:**
```json
{
  "streetAddress": "Katu 2",
  "postalCode": "00100",
  "city": "Helsinki",
  "country": "Suomi"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "street_address": "Katu 2",
  "postal_code": "00100",
  "city": "Helsinki",
  "country": "Suomi"
}
```

### DELETE /customeraddresses/{id}

**Pyyntö:**
```json
{}
```

---
## Toimittaja

### GET /supplier

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
[
  {
    "id": 1,
    "phone": "0501234567",
    "email": "teppo@testioy.fi",
    "name": "Testi Oy",
    "contact_name": "Teppo Toimittaja"
  }
]
```

### GET /supplier/{id}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
{
  "id": 1,
  "phone": "0501234567",
  "email": "teppo@testioy.fi",
  "name": "Testi Oy",
  "contact_name": "Teppo Toimittaja"
}
```

### POST /supplier

**Pyyntö:**
```json
{
  "name": "Testi Oy",
  "contactName": "Teppo Toimittaja",
  "phone": "0501234567",
  "email": "teppo@testioy.fi",
  "streetAddress": "Tehtaankatu 2",
  "postalCode": "20100",
  "city": "Turku",
  "country": "Suomi"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "name": "Testi Oy",
  "contact_name": "Teppo Toimittaja",
  "phone": "0501234567",
  "email": "teppo@testioy.fi"
}
```

### PUT /supplier/{id}

**Pyyntö:**
```json
{
  "name": "Testi Oy",
  "contact_name": "Teppo T. Toimittaja",
  "phone": "0507654321",
  "email": "teppo.uusi@testioy.fi"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "name": "Testi Oy",
  "contact_name": "Teppo T. Toimittaja",
  "phone": "0507654321",
  "email": "teppo.uusi@testioy.fi"
}
```

### DELETE /supplier/{id}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
{}
```

---
## Toimittajaosoitteet

### GET /supplieraddresses/

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
[
  {
    "id": 1,
    "street_address": "Tehtaankatu 2",
    "postal_code": "20100",
    "city": "Turku",
    "country": "Suomi"
  }
]
```

### GET /supplieraddresses/{id}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
{
  "id": 1,
  "street_address": "Tehtaankatu 2",
  "postal_code": "20100",
  "city": "Turku",
  "country": "Suomi"
}
```

### POST /supplieraddresses?supplierId={supplierId}

**Pyyntö:**
```json
{
  "streetAddress": "Tehtaankatu 2",
  "postalCode": "20100",
  "city": "Turku",
  "country": "Suomi"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "street_address": "Tehtaankatu 2",
  "postal_code": "20100",
  "city": "Turku",
  "country": "Suomi"
}
```

### GET /supplieraddresses/by-supplier/{supplierId}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
{
  "id": 1,
  "street_address": "Tehtaankatu 2",
  "postal_code": "20100",
  "city": "Turku",
  "country": "Suomi"
}
```

### PUT /supplieraddresses/by-supplier/{supplierId}

**Pyyntö:**
```json
{
  "streetAddress": "Tehtaankatu 3",
  "postalCode": "20100",
  "city": "Turku",
  "country": "Suomi"
}
```
**Vastaus:**
```json
{
  "id": 1,
  "street_address": "Tehtaankatu 3",
  "postal_code": "20100",
  "city": "Turku",
  "country": "Suomi"
}
```

---
## Loppu varastosta

### DELETE /outofstock/cleanup

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
"OutOfStock table cleaned! Products with stock are removed."
```
### GET /outofstock

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
[
    {
        "categoryId": 3,
        "id": 161,
        "priceEach": 60.47,
        "product": {
            "name": "Swift Shield 686",
            "description": "Worry shoulder level garden admit.",
            "price": 60.47,
            "stock_quantity": 0,
            "category_id": 3,
            "supplier_id": 53,
            "hibernateLazyInitializer": {}
        },
        "productName": "Swift Shield 686",
        "supplierId": 53
    }
[
```
## Tilauslokit

### GET /orderlogs

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
[
  {
    "id": 1,
    "orderId": 10,
    "customerId": 5,
    "loggedAt": "2026-03-15T12:00:00"
  }
]
```

### GET /orderlogs/{id}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
{
  "id": 1,
  "orderId": 10,
  "customerId": 5,
  "loggedAt": "2026-03-15T12:00:00"
}
```

### GET /orderlogs/by-order/{orderId}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
[
  {
    "id": 1,
    "orderId": 10,
    "customerId": 5,
    "loggedAt": "2026-03-15T12:00:00"
  }
]
```

### GET /orderlogs/by-customer/{customerId}

**Pyyntö:**
```json
{}
```
**Vastaus:**
```json
[
  {
    "id": 1,
    "orderId": 10,
    "customerId": 5,
    "loggedAt": "2026-03-15T12:00:00"
  }
]
```

---





Koodi on refaktoroitu paketteihin:
* Entity
* Controller
* Repositories
* Service
* DTO

