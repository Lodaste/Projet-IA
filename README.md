# Projet-IA
Moteur de fait chainage avant arrière

## Moteur de niveau 0

### Mise au propre des variables de l'algorithme

**Syntaxe**
- mot : chaine de caractères
- élément mot | NON mot
- fait : élément
- prémisse/antécédent : *élément | élément ET prémisse
- conséquent : prémisse
- règle : nom, prémisse -> conséquent

**Variables globales**
- BR : base de règles, ensemble de règles
- Demandables : ensemble des faits dont la valeur peut être demandée à l'utilisateur (≠ des fait déductibles par inférences)
- BF : base de fait, les fait initiaux
- VF(fait) : valeur d'un fait (booléen)dans BF
- VA (mot, règle) : valeur (*affirmation (V) ou négation (F)*) du mot dans l'**antécédent** de la règle
- VC(mot, règle)  : valeur (*affirmation (V) ou négation (F)*) du mot dans le **conséquent** de la règle
- bool inf : effectuer une inférence (ou pas)
- int nbrInf : nombre d'inférences 
