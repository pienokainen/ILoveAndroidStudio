Tehtävänanto ohjelman myöhempää tekemistä varten deadlinen ulkopuolella.

<!-- TEHTÄVÄ 9.1
 9.1. Tee käyttöliittymä, jossa on mahdollista listata kaikki Finnkinon teatterit pudotusvalikossa. 
 Pudotusvalikosta voi siis valita teatterin ja teatterin valinnan jälkeen ohjelmaan listataan kyseisessä teatterissa näytettävät elokuvat. 
 Toiminnallisuuksia ei tarvitse vielä toteuttaa, tärkeintä on saada komponentit paikalleen. 
 Mukana pitäiis olla erilaiseet hakukriteerit kuten päivämäärä, kellonaika, elokuvan nimi, ja paikka. 
-->

<!-- TEHTÄVÄ 9.2
 9.2. Lähde etsimään Finnkinon elokuvatarjontaa osoitteesta http://www.finnkino.fi/xml. 
 Tee käyttöliittymän taustalle ohjelma, jonka avulla on mahdollista ladata XML-tiedosto, missä käsitellään toimipaikkoja (areas XML). 
 Luo myös erillinen luokka, jonka sisälle säilöt jokaisen elokuvateatterin tiedot. 
 Tarvitset siis luokan, joka pitää kirjaa kaikista elokuvateattereista tietorakenteen avulla, sekä luokan,
 joka sisältää elokuvateatterin tiedot (Paikka ja ID). Pääluokan voit sitten integroida käyttöliittymään. 
 Käyttöliittymään päivitetään aluksi pudotusvalikko niin, että käyttäjä voi valita haluamansa elokuvateatterin listasta. 
-->

<!-- TEHTÄVÄ 9.3
 9.3. Lähdetään seuraavaksi hakemaan tietoa päivän näytöksistä teatterikohtaisesti. 
 Tiedon hakemiseen tarvitaan haluttu päivämäärä (tämä päivä) sekä teatterin ID-numero. Näistä tiedoista muodostuu haluttu URL muotoon 
 https://www.finnkino.fi/xml/Schedule/?area=<teatterinID>&dt=<päivämäärä pp.kk.vvvv>
 http://www.finnkino.fi/xml/Schedule/?area=<teatterinID>&dt=<päivämäärä pp.kk.vvvv>    
  <- ja >-merkit eivät kuulu urliin, vaan kuvastavat parametriä! Yllä kaksi vaihtoehtoa, https ja http. Kokeilkaa ensin https ja jos ei toimi, niin http.
 Parsi saadut esitystiedot aina, kun teatteri on valittu ja esitykset halutaan katsoa. 
 Käytä esittämiseen jotain lista-komponenttia (esim. RecyclerView, ScrollView tai ListView), johon lisäät elokuvat omille rivilleen. 
 Kuten edellisessä tehtävässä, käyttöliittymä vain esittää tiedot, mutta ei itse sisällä mitään parsimiseen tai tiedon säilömiseen liittyvää dataa. 
 Hetkellinen tietorakenteen käyttö on kuitenkin sallittua, jos on mahdollista osoittaa sen olevan tarpeellista. 
-->

<!-- TEHTÄVÄ 9.4
 9.4. Lisää ohjelmaan toiminnallisuus, jonka avulla käyttäjä voi syöttää päivämäärän sekä kellonaikavälin, jolta haluaa katsella elokuvatarjontaa. 
 Päivämäärä vaikuttaa suoraan datan hakemiseen ja kellonaika vaikuttaa siihen, mitä dataa valitaan näytettäväksi. 
 Tee siis vapaavalintaisia kenttiä, joihin käyttäjä voi syöttää päivämäärän ja aloita jälkeen sekä aloita ennen,
 miltä väliltä elokuvia haetaan (väli, josta elokuvat alkavat). Jos kaikki kentät jätetään tyhjiksi, haetaan päivän kaikki elokuvat valitussa teatterissa.  
-->

<!-- TEHTÄVÄ 9.5
 9.5. Lisää hakutoiminto, jolla voidaan hakea elokuvan nimen avulla kaikki ne paikat ja ajat, jolloin elokuvaa näytetään. 
 Hakutulosten pitäisi listata elokuvan nimi otsikkona ja sen jälkeen kaikkien esittävien teatterien nimet ja esitysajat käyttäjän syötteen mukaan
 (eli hakutoiminto etsii edellisten tehtävien mukaisten rajoitusten mukaan JA jos teatteria ei ole annettu, haku etsii kaikista teattereista. 
 Huom: Eri teatterialueita on 9 kun huomioit, että osa id-numeroista käy useamman teatterin läpi. ID 1029 ei näytä kaikkia. ).
-->

Ei näkyvä muille kuin itselleni
