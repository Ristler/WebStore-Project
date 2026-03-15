Sovellus on tarkoitettu verkkokaupan ylläpitäjille.
Sovellus käyttää Spring Web- ja Spring Data JPA -kirjastoja.


Käytettävissä olevat endpointit:

- ASIAKKAAN HALLINTA -
* GET localhost:8080/customer (Hakee kaikki asiakkaat)
* GET localhost:8080/customer/{id} (Hakee tietyn asiakkaan)

- TILAUKSEN HALLINTA -
* POST localhost:8080/order/post (Hakee tiet)

* GET localhost:8080/order (Hakee kaikki tilaukset)
* GET localhost:8080/order/{id} (Hakee tietyn tilauksen)


## Product (`/product`)
| Metodi | Endpointti            | Kuvaus                     |
|--------|-----------------------|----------------------------|
| GET    | /product              | Näytä kaikki tuotteet      |
| GET    | /product/{id}         | Hae tuote ID:n perusteella |
| POST   | /product              | Lisää uusi tuote           |
| PUT    | /product/{id}         | Päivitä tuote ID:n avulla  |
| DELETE | /product/{id}         | Poists tuote ID:n avulla   |

---

## Order (`/order`)
| Methodi | Endpointti                     | Kuvaus                             |
|--------|---------------------------------|------------------------------------|
| GET    | /order/                         | Näytä kaikki tilaukset             |
| GET    | /order/{id}                     | Hae tilaus ID:n perusteella        |
| POST   | /order/post                     | Luo uusi tilaus                    |
| PUT    | /order/{id}                     | Päivitä tilaus ID:n avulla         |
| DELETE | /order/{id}                     | Poista tilaus ID:n avulla          |
| GET    | /order/by-customer/{customerId} | Hae tilaukset asiakkaan ID:n avulla|
| DELETE | /order/clearcancelled           | Poista kaikki peruutetut tilaukset |
| PATCH  | /order/{id}/status              | Päivitä tilauksen status tilaa     |
  



Koodi on refaktoroitu paketteihin:
* Entity
* Controller
* Repositories
* Service
* DTO
