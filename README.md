# EasyFix
De backend applicatie voor bedrijven die IT support verlenen.

## Functioneel ontwerp
Voor mijn eindopdracht ga ik een variatie maken op de voorbeeldcasus zoals deze staat beschreven in het document 'Integrale eindopdracht Backend 1.02 (5).pdf'.
Ik ga een systeem bouwen voor een IT winkel genaamd 'EasyFix' waarbij klanten een computer kunnen afleveren voor onderhoud en/of reparatie.

### Administratief medewerker [ADMIN]
Wanneer de klant voor het eerst de winkel betreed, voegt een administratief medewerker de klant en de computer toe aan het systeem.
De afspraak wordt automatisch op 'Reported' gezet.
De medewerker kan vervolgens een moment in het systeem selecteren waarop de computer kan worden nagekeken.

### Expert [EXPERT]
Een expert kan in een handig overzicht, alle klanten met de status 'Reported' weergeven.
De expert controleert de computer en voegt eventueel gevonden tekortkomingen toe in het systeem door de afspraak bij te werken.
Nadat de computer is gecontroleerd neemt de expert contact op met de klant om de kosten voor het eventuele onderhoud te bespreken.

#### Klant niet akkoord
Is de klant niet akkoord dan zet de expert de reparatie op 'Canceled', stelt hij de bon op voor de controle en kan de klant de computer ophalen.

#### Klant akkoord
Is de klant akkoord dan kan de expert een nieuwe datum selecteren en zet hij de status van de reparatie op 'Repairing'.
De expert voert de reparatie uit en zet daarbij elk onderdeel die tijdens de reparatie is gebruikt in het systeem.
Daarnaast worden alle handelingen toegevoegd aan het systeem.
Stel: De expert vervangt de harde schijf, dan wordt de harde schijf aan de reparatie toegevoegd en worden de handelingen
'created a backup of the system, replaced the harddrive and reinstalled the OS' aan de reparatie toegevoegd.
Al de gebruikte onderdelen staan in het systeem en dienen gemakkelijk geselecteerd te kunnen worden door de expert.

Zodra de reparatie is afgerond, kan de reparatie op 'Complete' worden gezet en kan de klant worden teruggebeld.
De klant wordt opgebeld door een administratief medewerker.
Deze medewerker kan een lijst opvragen met alle klanten die een computer ter reparatie hebben achtergelaten.

### Kassamedewerker [CASHIER]
Wanneer de klant de computer komt ophalen zal een kassamedewerker de bon laten uitdraaien door het systeem.
De bon bevat de controle, de gebruikte onderdelen, de daarbij uitgevoerde handelingen en de bijbehorende bedragen.
Zodra de klant heeft betaald, wordt de status van de klant op 'Paid' gezet.

### Backoffice [BACKOFFICE]
De backoffice-medewerker voegt onderdelen (naam, prijs, voorraad) toe aan het systeem en beheert deze.

## Installatiehandleiding

### Docker
Download en installeer Docker voor Windows/Linux/Mac via de officiële website https://www.docker.com/products/docker-desktop

Navigeer naar de map waar het bestand `EasyFix-0.0.1-SNAPSHOT.jar` staat en voer het volgende commando uit in de console: `docker-compose up` 
om de benodigde containers te starten en de bijbehorende 'images' te downloaden.

### En nu starten
Wanneer in de console de regel 'Application successfully started!' verschijnt is de installatie voltooid en is deze klaar voor gebruik.
Navigeer in de browser naar `localhost:8080` en log in met een van de hieronder vermelde gebruikers.

### Voorbeeld gebruikers

| Username              | Password               |
| --------------------- | :--------------------: |
| admin@easyfix.nl      | EasyFixAdminLogin      |
| expert@easyfix.nl     | EasyFixExpertLogin     |
| cashier@easyfix.nl    | EasyFixCashierLogin    |
| backoffice@easyfix.nl | EasyFixBackofficeLogin |

## Verantwoording
