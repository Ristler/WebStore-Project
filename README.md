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
| Metodi | Endpoint              | Kuvaus                |
|--------|-----------------------|----------------------------|
| GET    | /product              | List all products          |
| GET    | /product/{id}         | Get product by ID          |
| POST   | /product              | Create a new product       |
| PUT    | /product/{id}         | Update a product by ID     |
| DELETE | /product/{id}         | Delete a product by ID     |

---
  



Koodi on refaktoroitu paketteihin:
* Entity
* Controller
* Repositories
* Service
* Base
