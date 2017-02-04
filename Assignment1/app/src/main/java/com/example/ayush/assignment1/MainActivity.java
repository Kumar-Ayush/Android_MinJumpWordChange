package com.example.ayush.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button= (Button) findViewById(R.id.findhop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed1= (EditText) findViewById(R.id.input1);
                EditText ed2= (EditText) findViewById(R.id.input2);
                EditText ed3= (EditText) findViewById(R.id.input3);

                TextView view1=(TextView) findViewById(R.id.view1);

                String stringInput=ed1.getText().toString();
                Log.d("MainActivity",stringInput);

                String[] input= stringInput.trim().split(",");

                String startWord=ed2.getText().toString();
                String endWord=ed3.getText().toString();

                if(startWord==endWord){
                    view1.setText("0 JUMP REQUIRED");
                    return;

                }

                else if (startWord.length()!=3 || endWord.length()!=3){
                    view1.setText("Input is wrong, Please enter the correct input");
                    return;
                }

                else{

                    Set<String> dictionary = new HashSet<String>();
                    int length=input.length;
                    for(int i=0;i<length;i++){
                        dictionary.add(input[i]);
                    }

                    Jump result = getShortestTransformationIterative(startWord, endWord, dictionary);


                    if(result!=null){

                        view1.setText("Total Jump required is "+result.getLength() + " and path taken is :"+ result.getPath());
                    }else{

                        view1.setText("No Path Available");
                    }
                }
            }
        });
    }


    private static Jump getShortestTransformationIterative(String startWord, String endWord, Set<String> dictionary){
        if(dictionary.contains(startWord) && dictionary.contains(endWord)){

            List<String> path = new LinkedList<String>();
            path.add(startWord);

            //Storing Intermediate paths in queue
            Queue<Jump> queue = new LinkedList<Jump>();
            queue.add(new Jump(path, 1, startWord));

            //Removing startWord used and remove from dictionary, so that we don't take it again.
            dictionary.remove(startWord);

            //Iterate till queue is not empty or endWord is found in Path.
            while(!queue.isEmpty() && !queue.peek().equals(endWord)){
                Jump jump = queue.remove();

                if(endWord.equals(jump.getLastWord())){
                    return jump;
                }

                Iterator<String> i = dictionary.iterator();
                while (i.hasNext()) {
                    String string = i.next();

                    if(changeByOne(string, jump.getLastWord())){

                        List<String> list = new LinkedList<String>(jump.getPath());
                        list.add(string);

                        //If the words differ by one alphabet then push it in queue to process later.
                        queue.add(new Jump(list, jump.getLength()+1, string));

                        //Once the word is traversed in path, we don't need that again, So pop it from dictionary.
                        i.remove();
                    }
                }
            }

            //if break because of Queue is empty then we didn't got any path till endWord.
            //If break because of endWord matched, then we got the Path and return the path from head of Queue.
            if(!queue.isEmpty()){
                return queue.peek();
            }
        }
        return null;
    }

    private static Jump returnShortestPath(String startWord, String endWord, Set<String> dictionary){

        //All the traversed Paths from startWord to endWord will be stored in allPath
        LinkedList<Jump> allPath = new LinkedList<Jump>();

        // Shortest path will be stored in shortestPath
        Jump shortestPath = new Jump(null);

        List<String> path = new LinkedList<String>();
        path.add(startWord);

        iterativeShortest(startWord, endWord, dictionary, new Jump(path, 1, startWord), allPath, shortestPath);

        return shortestPath;
    }

    private static void iterativeShortest(String startWord, String endWord, Set<String> dictionary, Jump jump, LinkedList<Jump> allPath, Jump shortestPath){
        if(jump.getLastWord().equals(endWord)){

            // For storing all paths
            allPath.add(new Jump(new LinkedList<String>(jump.getPath())));

            //store the shortest path from all paths available
            if(shortestPath.getPath()==null || shortestPath.getPath().size()> jump.getPath().size()){
                shortestPath.setPath(new LinkedList<String>(jump.getPath()));
                shortestPath.setLength(jump.getPath().size());
            }
            return;
        }

        Iterator<String> i = dictionary.iterator();
        while (i.hasNext()) {
            String string = i.next();

            if(changeByOne(string, jump.getLastWord()) && !jump.getPath().contains(string)){

                List<String> path = jump.getPath();
                path.add(string);

                //New word found in intermediate path, Start visiting new word from start again.
                iterativeShortest(startWord, endWord, dictionary, new Jump(path, jump.getLength()+1, string), allPath, shortestPath);

                //After visiting new word, remove it from intermediate path.
                path.remove(path.size()-1);
            }
        }
    }

    private static boolean changeByOne(String word1, String word2){
        if (word1.length() != word2.length()) {
            return false;
        }

        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }
        return (diffCount == 1);
    }
}
