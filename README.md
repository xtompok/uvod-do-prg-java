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
    - na začátku provede `pocatek`, typicky `int i=0` a zkontroluje se `podminka`
    - po konci každé iterace se provede `inkrement`, typicky `i++`
    - po provedení inkrementu se zkontroluje `podminka`, typicky `i<10`
        - pokud je splněna, vykoná se `kod`
	- pokud není splněna, cyklus končí a pokračuje se příkazem za cyklem
  - cykly se dají vnořovat
    - pro vnitřní cyklus chcete použít jinou řídící proměnnou (obvykle `i`,`j`,`k`,`l`,...), jinak se vám vnější cyklus rozbije
