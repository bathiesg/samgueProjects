/*
 * Morpion.java
 * 
 * Copyright 2016 Samba Gueye <gueye.smba@gmail.com>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

//package morpion;

/**
 * Modelise le jeu de Morpion
 * 
 * il s'agit d'un jeu constitue d'une table de 3 lignes et 3 colonnes.
 * il ya deux jours: un avec des pions ronds et l'autre avec des pions croix.
 * si un joueur parvient a placer ses pions en lignes ou en colonnes ou en diagonal alors il est vainqueur
 * 
 */
class JeuMorPion {
    //si la case est vide alors sa valeur est 0
    private final static int VIDE = 0;
    //le pion rond vaut 1
    private final static int ROND = 1;
    //le piuon croix vaut 2
    private final static int CROIX = 2;
    
    //declarons une table qui sera la grille de jeu
    private int[][] grille;
    
    
    //inicialisons le jeu
    
    public void initialise() {
        grille = new int[3][3];
        for(int i = 0; i < grille.length; i++) {
            for(int j = 0; j < grille[i].length; j++) {
                grille[i][j] = VIDE;
            }
        }
    }
    
    /**
     * placer un coup sur le tablier
     * 
     * @param ligne - la ligne 0, 1, 2
     * @param colonne - la colonne  0, 1, 2
     * @param coup - coup à placer (ROND ou CROIX)
     * @return true si le coup a pu être placé, false au cas contraire
     */
    //comme que l'utilisateur final ne pourra pas acceder a cette methode pour la modifier, elle sera private
    private boolean placerCoup(int ligne, int colonne, int coup) {
        //si la ligne choisie ou la colonne chosie n'appartient pas au tablier, le coup ne pourra pas être placé
        if (ligne < 0 || ligne >= grille.length || colonne < 0 || colonne >= grille[ligne].length) {
            throw new RuntimeException("Ligne valides = ["+0 + ", "+grille.length+"] : Colonnes valides = ["+0+", "+grille[ligne].length+"]");
        }
        
        //si case choisie est vide alors on pourra placer le coup
        if (grille[ligne][colonne] == VIDE) {
            grille[ligne][colonne] = coup;
            return true;
        } else {
            //c'est la case choisie est déja occupée
            throw new RuntimeException("La case " +grille[ligne][colonne]+ "est déja occupée");
            //return false;
        }
    }
    
    //verifions si le jour de pion rond a pu placer son pion a la case desiree
    public boolean placerRond(int ligne, int colonne) {
        return placerCoup(ligne, colonne, ROND);
    }
    
    //verifions si le jour de pion croix a pu placer son pion a la case desiree
    public boolean placerCroix(int ligne, int colonne) {
        return placerCoup(ligne, colonne, CROIX);
    }
}