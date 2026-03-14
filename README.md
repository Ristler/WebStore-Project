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
  



Koodi on refaktoroitu paketteihin:
* Entity
* Controller
* Repositories
* Service
* Base
