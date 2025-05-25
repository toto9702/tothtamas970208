Beadandó feladat.

A következő végpontok lettek megvalósítva:
    - http://localhost:8080/primszam?numberString=3
        --> A paraméterül kapott számról eldönti, hogy szöveg e vagy szám. Amennyiben szám akkor pedig eldönti, hogy prím e vagy sem. Megfelelő hibakezeléssel le van kezelve ha szöveget ad meg a felhasználó
    - http://localhost:8080/melyiknap?dateString=2025-05-26
        --> A paraméterül kapott dátumról eldönti, hogy a hét melyik napjára esik. Itt is megfelelő hibakezelés van használva. Az elfogadott dátum típusok a következőek: yyyy-MM-dd, yyyy.MM.dd, yyyy/MM/dd
    - http://localhost:8080/maganhangzo?inputString=dinnyel%C3%A9
        --> A paraméterül kapott szövegről eldönti, hogy mennyi magánhangzót tartalmaz. A kis és nagy magánhangzókat is számolja a magyar ábc szerint.

Az alkalmazáshoz swagger is lett behúzva ami ezen a linken érhető el: http://localhost:8080/swagger-ui/index.html#/

Az alkalmazás docker konténerből is indítható a következő paranccsal a docker mappából: docker compose -f dc-backend.yml up

Továbbfejleszthetőségi lehetőségek:
    -Akár minden végpontnál általánosságban egy saját státuszt is bevezethetnénk és a Frontend erről a hibakódról tudná, hogy milyen hibaüzenetet jelenítsen meg a képernyőn. Ezáltal több hibaágat is belehetne hozni, hogy pl prímeknél ha negatív számot adunk meg akkor térjünk vissza mondjuk a 001-es hibakóddal ilyenkor belenne FE oldalon állítva egy konstans érték, hogyha 001 jön vissza akkor azt a szöveget írja a felületre, hogy nem lehet negatív a input értékünk. Ilyen hibaákakból lehet néhány eset.
    - A dátumnál a napokat és a magánhangzók értékeit nem a memóriába hanem db-be tárolnám el és onnan szednénk be. Ezáltal lenne egy mondjuk mysql konténer amitől a dc-backend compose fájlunk függne (depends on kell bele) és adatbázisba egy liquibase fájlból 2db insert scripttel tölteném be az adatokat és így szebb lenne a mappelése is a dátumoknak illetve a magánhangzók is db szinten lennének eltárolva.
    
    