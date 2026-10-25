import Graphs.AdjacencyListGraph;
import Graphs.Graph;
import Graphs.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
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
            }

            System.out.print("What node would you like to start BFS at? ");
            String startNode = scanner.nextLine().trim();

            Node start = adjListGraph.getNode(startNode);
            runBFS(adjListGraph, start);
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    /*
    BFS is FIFO, so we use a queue.
     */
    public static void runBFS(Graph graph, Node start) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.println(current.getName());

            for (Node neighbor : current.getNeighbors().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}

