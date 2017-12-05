# Domácí úkol 2 - IDW

## Motivace

Pokud naměříme v prostoru nějaká data, často tato data mají smysl nejen v
místě měření, ale hodilo by se nám i odhadnout, jak by měřená veličina vypadala
v okolí naměřených dat. K tomuto účelu se používají interpolace. Abychom mohli
odhadovat vlastnosti veličiny na celé ploše, interpolujeme obvykle z naměřených
bodů čtvercovou nebo obdélníkovou mřížku, nad kterou můžeme snadno provádět
další analýzy. V tomto úkolu bude cílem naprogramovat metodu inverzní vážené
vzdálenosti. 

## Zadání

Napište neinteraktivní program, který bude interpolovat naměřená data metodou
inverzní vážené vzdálenosti (IDW). Program dostane jako argumenty vstupní a
výstupní soubor a spočítá interpolaci vstupních dat v mřížových bodech sítě 100x100 bodů.
Síť má takové rozměry, aby její krajní hrany obsahovaly body s minimálními
respektive maximálními souřadnicemi. V základní verzi programu počítejte s
pevným exponentem 2. Při programování počítejte s tím, že vstupních bodů můžou
být i desetitisíce.

### Vstup
Vstupní i výstupní soubor je ve formátu CSV a obsahuje desetinná čísla (s desetinnou
tečkou) oddělená čárkami. Vstupní soubor obsahuje na prvním řádku počet řádků
naměřených dat a další řádky vždy obsahují x-ovou souřadnici, y-ovou souřadnici
a naměřenou hodnotu na těchto souřadnicích. 

### Výstup
Výstupní soubor bude obsahovat 100 řádků po 100 položkách, což budou
interpolované hodnoty v mřížových bodech. Hodnoty zaokrouhlujte na dvě desetinná místa.

### Další požadavky
Program by měl ošetřovat i nekorektní vstupy, v případě chyby nebo výjimky by
měl na chybový výstup (`System.err`) vypsat popis chyby a skončit s chybou
(`System.exit(<cislo>)`.  

### Doporučení

Předtím, než začnete programovat, rozmyslete se, jak by měl program fungovat a
pro ucelené části používejte metody. Napište si kostru programu a pak
implementujte jednotlivé metody, průběžně testujte, zda se chovají dle
očekávání. 

Nebojte se použít dokumentaci. Pokud vám není jasné, jak IDW funguje, půjčte si
skripta od Ježka nebo se poraďte se spolužáky, co měli/mají zapsané interpolace.

Výsledky si vizualizujte, například v Excelu, Calcu nebo jiném vhodném programu
(gnuplot), odhalíte tím zjevné chyby.

### Odevzdání
Odevzdávat budete kompletní zdrojové kódy projektu a soubor s dokumentací. Vše
bude zabalené v zip souboru, který bude obsahovat adresář `du2_jmeno_prijmeni`,
ve kterém bude adresář s projektem, soubor s dokumentací a jar soubor se
sestavenou aplikací, tedy například:
```
du2.zip
|
\du2_tomas_pokorny
  |- dokumentace.md
  |- du2.jar
   \ du2
      |- build.xml
      |- src
      ...  
```
Před zabalením adresáře projektu dejte Clean, ať neposíláte zbytečně dočasné
soubory. Zip archiv mi pošlete mailem. 

Deadline bude 17.12. 8.03. Úkoly odeslané po deadlinu budou brány jako neodevzdané. Pokud
odevzdáte úkol vícekrát, budu hodnotit poslední odevzdání před deadlinem.
Každému, kdo mi pošle úkol, odpovím, že jsem ho přijal a že se mi podařilo zip
rozbalit. Pokud neodpovím, urgujte.

Detaily pro odevzdání přes GitHub viz sekce *Odevzdání přes GitHub*.


### Předčasné odevzdání
Pokud odevzdáte úkol dopředu, zkusím se na něj podívat a napsat vám případné
nedostatky. Tato možnost není garantovaná, ale budu se snažit odbavovat úkoly co
nejrychleji. Zaručuji vám pouze to, že na úkoly se budu dívat v tom pořadí, v
jakém mi budou doručeny. Rovněž nezaručuji, že najdu v programu všechny chyby
napoprvé, tudíž pokud si nějaké nevšimnu, není to garance, že máte program
správně, závazné je pouze hodnocení po deadlinu. Pokud budete odevzdávat přes
GitHub, chyby vám vystavím jako Issue. 

### Bodování
- 2b za funkční aplikaci pro korektní vstupy
- 5b za funkční aplikaci ošetřující nekorektní vstupy
- 2b za kvalitu kódu
- 2b za komentáře v kódu
- 1b za dokumentaci

Kvalitou kódu se rozumí použití vhodných prostředků k dosažení cíle,
minimalizace opakujícího se kódu, vhodné odsazení a oddělení funkčních celků,
-použití metod tam, kde to dává smysl.

Komentáře v kódu jsou důležité, aby člověk, co si váš kód čte, získal přehled o
tom, co kód dělá. Nekomentujte každý řádek, ale jednotlivé funkční celky. Pokud
používáte metody (a že byste měli), u každé napište, jaké má vstupy a co vrací
jako výstup, pro toto použijte
[JavaDoc](http://www.oracle.com/technetwork/articles/java/index-137868.html).
Komentářů by mělo být výrazně méně než kódu.

Dokumentací se rozumí textový soubor (ve formě čistého textu, např. .txt), kde
bude popsána fuknčnost programu, funkce programu a stručný popis, jak program
pracuje. Nepište romány, mělo by stačit 50 -- 75 řádků při 80 znacích na řádek.
Neopisujte přesně zadání, jen ho stručně shrňte, zadání si může každý přečíst
tady. Soubor vhodně formátujte, například pomocí
[MarkDownu](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet),
inspiraci si vezměte například z tohoto souboru.

Postup, jak domácí úkol napsat, spolu klidně konzultujte, ale kód pište každý
sám. Pokud objevím identické či nápadně podobné řešení, oboduji je jednou a body
rovnoměrně rozdělím mezi autory. 

### Příklad běhu programu

## Bonusové body

Za různé nadstavby k zadání můžete získat bonusové body. Pokud je uvedeno, že
program může dostat nějaký parametr, pak pokud se vyskytují nějaké parametry,
tak budou vždy před vstupním a výstupním souborem. Vzájemné pořadí parametrů
může být libovolné. Program by se tedy volal jako `java -jar soubor.jar -p 10
in.csv out.csv`. 

### Používání Gitu pro vývoj (1 b)

Pokud budete pro verzování používat Git, vytvořte si účet na
[GitHubu](https://github.com) nebo jiné
podobné stránce a úkol můžete odevzdat přes něj. Kromě samotného odevzdání je
třeba, aby byl repozitář používán i pro vývoj, tedy by měl obsahovat průběžně
commitovanou práci.  Repozitář by měl obsahovat jak
program, tak případný soubor s dokumentací, za hodnocenou verzi se počítá
poslední commit pushnutý na GitHub před deadlinem. Repozitář nemusí, ani by
neměl, obsahovat sestavený jar soubor, ten v tomto případě nemusíte vůbec
odevzdávat. Pokud budete potřebovat pomoct, pište mi.

### Volitelný exponent (1 b)
Program může dostat parametr `-p <cislo>` a pak použije toto číslo jako exponent
ve váhové funkci.

### Volitelný vyhlazovací koeficient (1 b)

Program může dostat parametr `-s <cislo>` a pak použije toto číslo jako
vyhlazovací koeficient. Nepůjde tedy o přesnou interpolaci, ale můžeme tím
snížit vliv chyb v měření.

### Volitelná velikost mřížky (1 b)

Program může dostat parametr `-g <sirka>x<vyska>` a místo standardní velikosti
mřížky použije mřížku `sirka x vyska`. 
