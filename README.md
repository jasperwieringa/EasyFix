# EasyFix
Backend application for IT support
De backend applicatie voor bedrijven die IT support verlenen.

# Functioneel ontwerp
Voor mijn eindopdracht ga ik een variatie maken op de voorbeeldcasus zoals deze staat beschreven in het document 'Integrale eindopdracht Backend 1.02 (5).pdf'.
Ik ga een backend systeem voor een IT winkel bouwen waarbij klanten hun computer kunnen afleveren voor onderhoud en/of reparatie.

### Administratief medewerker
Wanneer de klant voor het eerst de winkel betreed, voegt een administratief medewerker de klant en de computer toe aan het systeem.
De afspraak wordt automatisch op 'Reported' gezet.
De medewerker kan vervolgens een moment in het systeem selecteren waarop de computer kan worden bekeken.

### Expert
Een expert controleert de computer en voegt eventueel gevonden tekortkomingen toe in het systeem.
Nadat de computer is gecontroleerd neemt de expert contact op met de klant om de kosten voor het onderhoud te bespreken.

#### Klant niet akkoord
Is de klant niet akkoord dan zet de expert de reparatie op 'Canceled', stelt hij de bon op voor de controle en kan de klant de computer ophalen.

#### Klant akkoord
Is de klant akkoord dan kan de expert een nieuwe datum selecteren en kan hij de status van de reparatie op 'Repairing' zetten.
De expert voert de reparatie uit en zet daarbij elk onderdeel die tijdens de reparatie is gebruikt in het systeem.
Daarnaast worden alle handelingen toegevoegd aan het systeem.
Stel: De expert vervangt de harde schijf, dan wordt de harde schijf aan de reparatie toegevoegd en worden de handelingen
'created a backup of the system, replaced the harddrive and reinstalled the OS' aan de reparatie toegevoegd.
Al de gebruikte onderdelen staan in het systeem en dienen gemakkelijk geselecteerd te kunnen worden door de expert.

Zodra de reparatie is afgerond, kan de reparatie op 'Complete' worden gezet en kan de klant worden teruggebeld.
De klant wordt opgebeld door een administratief medewerker.
Deze medewerker kan een lijst opvragen met alle klanten die een computer ter reparatie hebben achtergelaten.

### Kassamedewerker
Wanneer de klant de computer komt ophalen zal een kassamedewerker de bon laten uitdraaien door het systeem.
De bon bevat de controle, de gebruikte onderdelen, de daarbij uitgevoerde handelingen en de bijbehorende bedragen.
Zodra de klant heeft betaald, wordt de status van de klant op 'Paid' gezet.

### Backoffice
Er is een backoffice medewerker die:
1. Onderdelen (naam, prijs, voorraad) kan toevoegen, bewerken en verwijderen in het systeem.

## Installatiehandleiding
### Database gegevens
Gebruikersnaam: easyfixy_h2_admin
Wachtwoord: ZrM4TnLFLH^fauxem*dkznPCLv9TKXn#j5fn6JAERtPh^yBLraQYR4um4ZPK

### Voorbeeld employees
Gebruikersnaam: admin@easyfix.nl
Wachtwoord: EasyFixAdminLogin

Gebruikersnaam: expert@easyfix.nl
Wachtwoord: EasyFixExpertLogin

Gebruikersnaam: cashier@easyfix.nl
Wachtwoord: EasyFixCashierLogin

Gebruikersnaam: backoffice@easyfix.nl
Wachtwoord: EasyFixBackofficeLogin

## Verantwoording
