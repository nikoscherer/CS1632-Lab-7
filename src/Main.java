import Graphs.AdjacencyListGraph;
import Graphs.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

        System.out.print("What file would you like to run BFS on? ");
        String fileName = scanner.nextLine().trim();

        try (BufferedReader br =
                     new BufferedReader(new FileReader("src/" + fileName))) {
            while(br.ready()) {
                String line = br.readLine().trim();
                String[] connection = line.split(" ");

                // Add nodes if they don't exist
                if (!adjListGraph.contains(connection[0])) {
                    adjListGraph.addNode(new Node(connection[0]));
                }
                if (!adjListGraph.contains(connection[1])) {
                    adjListGraph.addNode(new Node(connection[1]));
                }

                adjListGraph.addConnection(connection[0], connection[1],
                        Double.parseDouble(connection[2]));



                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}