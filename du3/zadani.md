# Domácí úkol 3 - třídění

## Motivace

Pokud zpracováváme velké množství dat, začne nás kromě správnosti zpracování
zajímat i rychlost zpracování. Rychlost můžeme ovlivnit konkrétním
počítačem či počítači, na kterém náš program spouštíme, zvoleným programovacím
jazykem a volbou algoritmu, který použijeme. Zatímco volba počítače a jazyka
obvykle ovlivňuje rychlost programu konstantním faktorem (násobí čas pro daný
vstup nějakou konstantou, například pokud program v jazyce *A* poběží *t* sekund,
program v "pomalejším" jazyce *B* poběží *2t* sekund), volba algoritmu může mít
výrazný vliv na rychlost programu vzhledem k velikosti dat. Pokud máme lineární
algoritmus, pak pro dvojnásobně velká data potřebujeme přibližně dvojnásobný
čas. Pokud je ale náš algoritmus kubický, potřebujeme 8x (2^3) více času na
výpočet. V rámci úkolu si rozdílné rychlosti algoritmů prakticky vyzkoušíte.

## Zadání

Napište program porovnávající jednotlivé třídící algoritmy, porovnejte jejich
rychlosti a zdůvodněte, proč se chovají tak, jak se chovají. Implementujte 2
"rychlé" a 2 "pomalé" třídící algoritmy, z toho jeden z rychlých musí být
Quicksort. Změřte rychlost běhu jednotlivých algoritmů na datech velikostí
*10^k*, kde *k=2,3,...6*. Změřte na
následujících typech dat:
 - náhodné integery
 - stříděné integery
 - setříděné integery, které mají 1% dvojic prvků náhodně prohozených

Výsledky vyneste do grafů a odůvodněte. 

### Vstup
Program 

### Výstup
Výstupem bude zdrojový kód programu (pro kontrolu správnosti) a zpráva v PDF s
popisy iomplementovaných algoritmů, grafy, zdůvodněními a použitou metodikou
měření (kolikrát jste měřili jaká data, jak jste generovali data, ...).

### Doporučení

Napište si funkce na jednotlivé třídící algoritmy. Nejprve se věnujte zdrojovému
kódu a nechte si ho zkontrolovat, ať pak nemusíte předělávat grafy a zdůvodnění.  

Pro měření rychlosti požijte `System.nanoTime()`.

Rychlost berte jako průměr časů z více třídění dat dané velikosti (desítky běhů u malých polí, jednotky běhů u velkých polí).
Měřte pouze rychlost třídění, nikoli čas potřebný na generování vstupu či jiné podpůrné operace.

### Odevzdání
Odevzdávat budete kompletní zdrojové kódy projektu a zprávu s grafy a zdůvodněními. Vše
bude zabalené v zip souboru, který bude obsahovat adresář `du3_jmeno_prijmeni`,
ve kterém bude adresář s projektem a soubor se zprávou, tedy například:
```
du3.zip
|
\du3_tomas_pokorny
  |- vysledky.pdf
   \ du3
      |- build.xml
      |- src
      ...  
```
Před zabalením adresáře projektu dejte Clean, ať neposíláte zbytečně dočasné
soubory. Zip archiv mi pošlete mailem. 

Deadline bude pět dní před datem, kdy chcete zápočet. Můžete odevzdávat
opakovaně, jako v minulých úkolech, a až budete chtít odevzdat finálně, napíšete
a já vám úkol oboduji. Každému, kdo mi pošle úkol, odpovím, že jsem ho přijal a
že se mi podařilo zip rozbalit. Pokud neodpovím, urgujte.

Detaily pro odevzdání přes GitHub viz sekce *Odevzdání přes GitHub*.

### Bodování
- 4b za správný zdrojový kód
- 4b za zprávu
- 2b za kvalitu kódu a komentáře

Kvalitou kódu se rozumí použití vhodných prostředků k dosažení cíle,
minimalizace opakujícího se kódu, vhodné odsazení a oddělení funkčních celků,
použití metod tam, kde to dává smysl.

Komentáře v kódu jsou důležité, aby člověk, co si váš kód čte, získal přehled o
tom, co kód dělá. Nekomentujte každý řádek, ale jednotlivé funkční celky. Pokud
používáte metody (a že byste měli), u každé napište, jaké má vstupy a co vrací
jako výstup, pro toto použijte
[JavaDoc](http://www.oracle.com/technetwork/articles/java/index-137868.html).
Komentářů by mělo být výrazně méně než kódu.

Postup, jak domácí úkol napsat, spolu klidně konzultujte, ale kód pište každý
sám. Pokud objevím identické či nápadně podobné řešení, oboduji je jednou a body
rovnoměrně rozdělím mezi autory. 


## Bonusové body

Za různé nadstavby k zadání můžete získat bonusové body. 

### Používání Gitu pro vývoj (1 b)

Pokud budete pro verzování používat Git, vytvořte si účet na
[GitHubu](https://github.com) nebo jiné
podobné stránce a úkol můžete odevzdat přes něj. Kromě samotného odevzdání je
třeba, aby byl repozitář používán i pro vývoj, tedy by měl obsahovat průběžně
commitovanou práci a zprávy u commitů by měly popisovat, co se v daném commitu
změnilo. Repozitář by měl obsahovat jak program, tak zprávu, pokud chcete,
můžete ji napsat v 
[MarkDownu](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet),
pak nemusíte odevzdávat PDF.
Pokud budete potřebovat pomoct, pište mi.

### Další třídící algoritmus (1 b za každý, max 2 body)
Implementujte další třídící algoritmus a přidejte ho do srovnání.

