# IO-Builings
![Build status](<https://travis-ci.org/PiotrJTomaszewski/IO-Builings.svg?branch=master>)

Projekt na laboratorium Inżynierii Oprogramowania
# INFO
 - Wszystkie zadania, które sobie zdefiniujemy dodajemy jako issues. Jak chcecie się zabrać za któryś issue, to dodajcie siebie w polu assignee. Zadania podzielone są czasem na mniejsze, które są dodane jako osobne issues. W głownym zadaniu są zawsze podlinkowane podrzędne. Dla przejrzystości, obok linków znajduje się checklista, można tam oznaczać ukończone zadania. ~pjt
 - W zakładce projects jest tablica dla pierwszego sprintu, nowe issues będą wskakiwać do 'to do' automatycznie. Jak zaczniecie implementować któreś z nich, przesuńcie pole do 'in progress', a po ukończeniu do 'Done'. Ułatwi nam to śledzenie, co się dzieje. Jakby co, issues po zakończeniu nie usuwamy, a jedynie zamykamy. ~pjt
 - Jeśli chcecie dostawać maile jak projekt przestanie się kompilować to dodajcie swojego maila do .travis.yml (Podobno działają tylko maile przypisane do konta na githubie). ~pjt
 - Wczytanie projektu do IntelliJ IDEA:
    - Sklonuj repo
    - W IDEA: File->New->Project From Existing Sources
    - Wybierz folder (ten, w którym znajduje się pom.xml)
    - Import project from external model -> Maven -> Nic nie zmieniamy, klikamy next->next->Wybieramy wersję sdk
   
# Building Info
Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.

## Struktura danych
- Lokacja to budynek, poziom, lub pomieszczenie
- Budynek może składać się z poziomów a te z pomieszczeń
- Każda lokalizacja jest charakteryzowana przez:
  - id – unikalny identyfikator
  - name – opcjonalna nazwa lokalizacji
- Pomieszczenie dodatkowo jest charakteryzowane przez:
  - area = powierzchnia w m^2
  - cube = kubatura pomieszczenia w m^3
  - heating = poziom zużycia energii ogrzewania (float)
  - light – łączna moc oświetlenia
