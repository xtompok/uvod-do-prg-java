# Úvod do programování
Zdrojové kódy a poznámky ke cvičení z Úvodu do programování

[Stránky](http://web.natur.cuni.cz/~bayertom/index.php/9-teaching/10-uvod-do-programovani) přednášky.

## Programové vybavení 

Na cvičení budeme programovat v Javě 8 v prostředí [NetBeans](https://netbeans.org/downloads/), stačí
verze Java SE, ale můžete používat i jiná prostředí, jsou-li vám bližší
([Eclipse](http://www.eclipse.org/downloads/eclipse-packages/),[IntelliJ
IDEA](https://www.jetbrains.com/idea/)).

Pro vývoj v Javě potřebujete JDK, můžete stáhnout spolu s NetBeans [na stránkách Oraclu](http://www.oracle.com/technetwork/java/javase/downloads/).
Pokud máte [64bitovou verzi
systému](https://support.microsoft.com/cs-cz/help/827218/how-to-determine-whether-a-computer-is-running-a-32-bit-version-or-64),
instalujte 64bitovou verzi JDK. 

Pro základní pochopení struktury programů si můžete vyzkoušet například [Google Blockly](https://developers.google.com/blockly/).

Věci probírané na jednotlivých cvičeních naleznete na [zvláštní stránce](prubeh.md)

## Možnosti sestavení
### Debug
 - slouží k ladění aplikace
 - v NetBeans spustí dodatečná okna sloužící k ladění
 - vlivem vložených ladících informací v kódu je pomalejší než v módu Release

### Release
 - slouží pro sestavení finální verze aplikace
 - takovouto aplikaci nemusí být možné jednoduše ladit
 - výkon aplikace bývá (i výrazně) vyšší než verze Debug
 - pokud máte aplikaci hotovou a funkční a předáváte ji někomu, obvykle se používá Release


## Základy syntaxe
 - pole
   - posloupnost prvků stejného typu (např. celé číslo)
   - na prvky se odkazuje hranatými závorkami, číslujeme od 0
 
 - funkce
   - pojmenovaný kus kódu
   - bere parametry zapsané v závorkách za jménem funkce
   - vrací datový typ napsaný před jménem funkce
   - tělo funkce napsané ve složených závorkách
   - z funkce se vrací pomocí `return`, funkce je ukončena a je vrácen výraz mezi return a středníkem
   - funkce může mít modifikátory, pro nás obvykle `public static`, bude vysvětleno později
 
 - proměnné
   - deklarují se pomocí `typ_proměnné jméno_proměnné`
   - přiřazení pomocí `=`, pozor na pole

 - porovnání vs. přiřazení
   - = je přiřazení, výsledkem je hodnota přiřazeného výrazu
   - == je porovnání, výsledek je pravda, pokud se levá strana rovná pravé, nepravda jinak
 
 - cyklus
   - viz Cykly

 - podmínka
   - logický výraz, například `b < 10`
   - vrací pravda pro cokoli nenulového či nepravda pro false, NULL, "", 0, 0.0, ...
   - `==` pro rovnost, pozor na záměnu s přiřazením
   - `!=` pro nerovnost

## Ladění
  - pokud kliknu vlevo na číslo řádku, vložím *breakpoint* 
  - pokud mám breakpoint, mohu mu upravit vlastnosti
    - pravé tlačítko nad ním, *Breakpoint->Properties*
    - mohu povolit *Condition* a dát podmínku, za jaké se má breakpoint aktivovat
  - pokud spustím aplikaci v režímu ladění (Ctrl+F5), pak se běh na každém *breakpointu* zastaví
  - po zastavení
    - stisknu *Continue* (F5), pak běh pokračuje k dalšímu breakpointu
    - stisknu *Stop* (Shift+F5), pak program ukončím 
    - použiji jednu z oranžových šipkových ikon, pak mohu skákat po řádcích (F8), do volaných funkcí (F7) či jinak ladit
    - v okně dole vidím aktuální hodnoty proměnných
  - opakovaným klikem na číslo řádku breakpoint zruším
  - sledování výrazů
    - při pozastaveném programu mohu v debugovacím okně přidat watch - sledování hodnoty výrazu
    - pravé tlačítko v okně *Variables*, pak *New Watch...* a vložit výraz ke sledování

## Aritmetika
  - používáme standardní matematické operátory
  - nelze implicitně konvertovat `double` na `int`, protože ztráta dat za desetinnou čárkou
  - pro explicitní přetypování `(jméno_typu) výraz`
  - pozor na celočíselné dělení: `60/7` != `60/7.0`
  - používejte závorky, pokud si nejste jistí
  - mnoho užitečných funkcí najdete v [java.lang.Math](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)
    - import pomocí `import static java.lang.Math.jméno_metody`
  - pokud používáme čísla s plovoucí řádovou čárkou (`double`, `float`), tak u hodnoty velké v aboslutní hodnotě mají nižší přesnost než `int` (viz 4. cvičení)

## Vstup a výstup
  - načítání čísla z klávesnice není přímočaré (viz funkce `readInt()` a `readDouble()`)
  - výpis do terminálu pomocí `System.out.println()`
  - formátovaný výstup pomocí `System.out.format()`
    - `%d` pro int
    - `%f` pro double
    - `%b` pro boolean
    - `%s` pro string
    - `%.5f` vytiskne 5 míst za desetinnou čárkou
    - `%6b` vytiskne boolean zarovnaný doprava na 6 znaků
    - `\n` vloží znak konce řádky
    - přesnou specifikaci formátu naleznete [v dokumentaci](https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax)

## Pole
  - deklaruje se jako `typ jmeno_promenne []`
  - definuje se jako `promenna = new typ[delka]`
  - k prvkům se přistupuje pomocí `pole[index]`
    - indexuje se od 0
  - počet prvků pole zjistíte pomocí `promenna.length`
  - pomocí `System.out.println` nelze tisknout celé pole naráz
  - nedefinované pole nemá délku a nelze přistupovat k jeho elementům

## Logické spojky
  - `!`,`&&`,`||`
  - pracují pouze s booleany
  - `!` je negace
  - `&&` je operace AND
  - `||` je operace OR
  - pozor na záměnu, existuje i `|` a `&`, ty dělají operace po bitech

## Cykly
  - `for (pocatek;podminka;inkrement){/*kod*/}`
    - jednotlivé části deklarace se oddělují středníkem, nikoli čárkou
    - na začátku provede `pocatek`, typicky `int i=0` a zkontroluje se `podminka`
    - po konci každé iterace se provede `inkrement`, typicky `i++`
    - po provedení inkrementu se zkontroluje `podminka`, typicky `i<10`
        - pokud je splněna, vykoná se `kod`
	- pokud není splněna, cyklus končí a pokračuje se příkazem za cyklem
  - cykly se dají vnořovat
    - pro vnitřní cyklus chcete použít jinou řídící proměnnou (obvykle `i`,`j`,`k`,`l`,...), jinak se vám vnější cyklus rozbije

## Funkce resp. metody
  - TODO

## Předávání kódu a aplikace dalším lidem
### Zdrojáky
  - v levém menu kliknout na projekt (ikona kávičky) → `Clean`
    - smaže dočasné soubnory  
  - v levém menu kliknout na projekt (ikona kávičky) → `Properties`
    - v otevřeném ookně najdete cestu k adresáři se zdrojáky
  - zkopírovat celý adresář se zdrojáky (např. `du1`)
### Aplikace
  - v menu `Run` dát `Clean and Build`
  - pomocí předchozího návodu najít adresář s projektem
  - v něm v adresáři dist je soubor .jar
  - tento soubor zkopírovat, kam je třeba

## Práce s GitHubem v NetBeans
### Vytvoření repozitáře a import do NetBeans
  - zaregistrujeme se na GitHubu
  - vytvoříme nový repozitář přes `New repository`
  - zkopírujeme si URL z rámečku
  - otevřeme NetBeansy
  - otevřeme klonovací okno přes `Team -> Git -> Clone...`
  - vložíme URL z GitHubu a přihlašovací údaje
  - zvolíme, kam chceme repozitář naklonovat
  - `Next`, `Next`, `Finish`
  - pak se nás NetBeansy zeptají, jestli chceme vytvořit nový projekt, tak chceme
  - vyplníme obvyklé údaje k novému projektu
  - klikneme pravým na projekt v levém sloupci, `Git->Add` nám přidá všechny potřebné soubory
  - pomocí `Team->Commit` uložíme nově vytvořený projekt do repozitáře

### Práce s repozitářem
  - provedeme změny ve zdrojovém kódu
  - pomocí `Team->Add` je přidáme k věcem pro commit
  - pomocí `Team->Commit` je uložíme do repozitáře, nezapomeneme napsat shruntí toho, co commitujeme
  - pomocí `Team->Remote->Push to origin` propíšeme naše změny na GitHub. Na případné hlášky odpovídáme ano.


## Tipy na psaní přehledného kódu
  - funkce mají dělat to, co je v názvu
      - podminkapol nemá dělit měřítkovým číslem
  - na začátku ošetřit nekorektní vstupy
    - dál v kódu je pak možno předpokládat korektní vstup, což šetří práci a nervy 
  - kontrola vstupu ve `while(true)`
    - pro interaktivní programy dává možnost uživateli se opravit
    - pro neinteraktivní programy nevhodné
  - negativní podmínky
    - používat s mírou, vhodné pro ošetření nekorektních vstupů
  - neopakovat kód, např. výpis rovnoběžky:
    - ve funkcích by měl být výkonný kód
    - v mainu lepidlo, které to celé drží pohromadě
        - vypisuje hlášky na výstup
	- zpracovává vstup od uživatele
	- na jeho základě volá jednotlivé funkce
  - neřetězit funkce
    - není vhodné na konci funkce zavolat další dlouhou funkci, která od aktuální nepřebírá žádná data
    - lepší je zavolat obě funkce postupně z mainu
    - usnadňuje to porozumění kódu po částech
  - přepočtové funkce jen na jednom místě
    - snadno se zapomene při opravě opravit všechny výskyty
  - nepoužívat `else` za dlouhým `if`ovým blokem
    - když se člověk dočte k else, už neví, k jakému `if`u patří a kterou podmínku ten `if` testoval
  - téměř každá funkce by se měla vejít na 1 obrazovku
    - člověk má omezeně velký kontext, který zvládne aktivně držet v paměti
  - používat prázdné řádky k oddělení logických částí kódu
    - například část zpracování vstupu od výpočetní části
