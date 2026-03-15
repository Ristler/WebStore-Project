Sovellus on tarkoitettu verkkokaupan ylläpitäjille.
Sovellus käyttää Spring Web- ja Spring Data JPA -kirjastoja.


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

## Tilaus (`/order`)
| Methodi | Polku                     | Kuvaus                             |
|--------|---------------------------------|------------------------------------|
| GET    | /order/                         | Näytä kaikki tilaukset             |
| GET    | /order/{id}                     | Hae tilaus ID:n perusteella        |
| POST   | /order/post                     | Luo uusi tilaus                    |
| PUT    | /order/{id}                     | Päivitä tilaus ID:n avulla         |
| DELETE | /order/{id}                     | Poista tilaus ID:n avulla          |
| GET    | /order/by-customer/{customerId} | Hae tilaukset asiakkaan ID:n avulla|
| DELETE | /order/clearcancelled           | Poista kaikki peruutetut tilaukset |
| PATCH  | /order/{id}/status              | Päivitä tilauksen status tilaa     |
  

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

Koodi on refaktoroitu paketteihin:
* Entity
* Controller
* Repositories
* Service
* DTO
