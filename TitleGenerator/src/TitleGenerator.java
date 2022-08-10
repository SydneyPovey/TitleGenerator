
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

//Sydney Povey
//Title generator, generates title no matter what phrase you input, based on APA standards
//output is copy-pastable
//Made July 11 2022
public class TitleGenerator {
    public static void main (String[]args){
        try{
            
            String title = "";
            do{
                title = JOptionPane.showInputDialog("Input the phrase you want to become a title (q to quit) :");
                if(title.equals("q")){
                    JOptionPane.showMessageDialog(null, "Program ended");
                }else{
                    title = title.toLowerCase();//makes the whole title lowercase to remove any random upper cases in the sentence
                    String[] splitTitle = title.split(" "); //splits title into its seperate words
                    String newTitle = ""; //var to carry the new title with uppercases

                    //The first word in a title is always capital regardless of word length
                    newTitle = newTitle + splitTitle[0].substring(0, 1).toUpperCase() + splitTitle[0].substring(1) + " ";

                    for(int i = 1; i<splitTitle.length; i++){ //goes through each word in the title after the first
                        if(splitTitle[i].contains("-")){ //Capitalizes the first letter after a "-", for example "Report-Based"
                            String[] splitWord = splitTitle[i].split("-");
                            for(int ii = 0; ii<(splitWord.length-1); ii++){
                                newTitle = newTitle + splitWord[ii].substring(0, 1).toUpperCase() + splitWord[ii].substring(1) + "-";
                            }
                            newTitle = newTitle + splitWord[(splitWord.length-1)].substring(0, 1).toUpperCase() + splitWord[(splitWord.length-1)].substring(1);
                            newTitle = newTitle + " ";
                        }else{
                            String[] splitWord = splitTitle[i].split(""); //splits each word in the title into its seperate characters

                            int counter = 0;
                            for(int ii = 0; ii<splitWord.length; ii++){
                                counter = counter +1;//counts how many characters are in the word
                            }

                            if(!(counter <= 3)){ //if the word isn't under three characters, it makes the first letter in the word an uppercase
                                newTitle = newTitle + splitTitle[i].substring(0, 1).toUpperCase() + splitTitle[i].substring(1) + " ";
                            }else{ //else, it will add the word without capitalizing
                                newTitle = newTitle + splitTitle[i] + " ";
                            }
                        }
                    }

                    //outputs the new title in a format that's copy-pastable
                    JTextArea textarea= new JTextArea(newTitle);
                    textarea.setEditable(true);
                    JOptionPane.showMessageDialog(null, textarea);
                }
            }while(!title.equals("q"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong, try again.");
        }
    }
       
}

