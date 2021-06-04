# EasyFix
Backend application for IT support
De backend applicatie voor bedrijven die IT support verlenen.

# Functioneel ontwerp
Voor mijn eindopdracht ga ik een variatie maken op de voorbeeldcasus zoals deze staat beschreven in het document 'Integrale eindopdracht Backend 1.02 (5).pdf'.
Ik ga een backend systeem voor een IT winkel bouwen waarbij klanten hun computer kunnen afleveren voor onderhoud en/of reparatie.

### Administratief medewerker
Wanneer de klant voor het eerst de winkel betreed, voegt een administratief medewerker de klant en de computer toe aan het systeem.
De medewerker selecteert een moment in het systeem waarop de computer kan worden bekeken.

### Expert
Een expert controleert de computer en voegt eventueel gevonden tekortkomingen toe in het systeem.
Nadat de computer is gecontroleerd neemt de expert contact op met de klant om de kosten voor het onderhoud te bespreken.

#### Klant niet akkoord
Is de klant niet akkoord dan zet de expert dat in het systeem, stelt hij de bon op voor de controle en kan de klant de computer ophalen.
In het systeem wordt de reparatie op 'niet uitvoeren' gezet.

#### Klant akkoord
Is de klant akkoord dan zet de expert een moment in het systeem waarop de computer zal worden gerepareerd.
De expert voert de reparatie uit en zet daarbij elk onderdeel die tijdens de reparatie is gebruikt in het systeem.
Daarnaast worden alle handelingen toegevoegd aan het systeem.
Stel: De expert vervangt de harde schijf, dan wordt de harde schijf aan de reparatie toegevoegd en worden de handelingen
'backup van het systeem maken, harde schijf vervangen en herinstalleren OS' aan de reparatie toegevoegd.
Al deze handelingen en onderdelen staan al in het systeem en dienen gemakkelijk geselecteerd te kunnen worden door de expert.
Wanneer eventuele handelingen niet in het systeem staan, kan de expert zijn of haar eigen handelingen met bijbehorende kosten aan de reparatie toevoegen.

Zodra de reparatie is afgerond, wordt de reparatie op 'voltooid' gezet en kan de klant worden teruggebeld.
De klant wordt opgebeld door een administratief medewerker.
Deze medewerker kan een lijst opvragen met alle klanten die een computer ter reparatie hebben achtergelaten.

### Kassamedewerker
Wanneer de klant de computer komt ophalen zal een kassamedewerker de bon laten uitdraaien door het systeem.
De bon bevat de controle, de gebruikte onderdelen, de daarbij uitgevoerde handelingen en de bijbehorende bedragen.
Zodra de klant heeft betaald, wordt de status van de klant op 'succes' gezet.

### Backoffice
Er is een backoffice medewerker die:
1. Onderdelen (naam, prijs, voorraad) kan toevoegen, bewerken en verwijderen in het systeem.
2. Handelingen (naam, prijs) kan toevoegen, bewerken en verwijderen in het systeem.

## Installatiehandleiding


## Verantwoording
