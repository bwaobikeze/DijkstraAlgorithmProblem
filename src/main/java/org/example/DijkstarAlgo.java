package org.example;

public class DijkstarAlgo {
    /*
     * The Function UseDijkstara()
     * Takes in two parameters first one being an adsency Matrix, and a integer Starting node
     * this function begins to apply the Dijkstar Algo on the graph that is passed  finding the shortest path
     * starting at the starting node that is passed in
     * as well as printing them out
     * */
    void UseDijkstra(int[][] AdjMatrix, int StartingNode){
        int count = AdjMatrix.length;
        boolean[] verVistit= new boolean[count];
        int[] dist=new int[count];
        for(int i=0; i< count; i++){
            verVistit[i]=false;
            dist[i]=Integer.MAX_VALUE;
        }

        dist[StartingNode]=0;
        for(int i=0;i<count;i++){
            int u =findMinDist(dist,verVistit);
            verVistit[u]=true;
            for(int v=0; v<count; v++){
                if(!verVistit[v]&& AdjMatrix[u][v] !=0 && (dist[u]+AdjMatrix[u][v]<dist[v])){
                    dist[v]=dist[u]+AdjMatrix[u][v];
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.println(String.format("Distance from %s to %s is %s", StartingNode, i, dist[i]));
        }
    }
    /*
    * The Function findMinDist()
    * Takes in two parameters first one being an integer array, and the second one being a boolean array
    * this function also keeps track of the visited nodes and through the vistVertiex array and finds the  next minimum
    * distance and returns it.
    * */
    int findMinDist(int[] distance,boolean[] vistVertex){
        int minDist= Integer.MAX_VALUE;
        int minDistVert=-1;
        for (int i=0; i<distance.length; i++){
            if(!vistVertex[i] && distance[i]<minDist){
                minDist=distance[i];
                minDistVert=i;
            }
        }
        return minDistVert;
    }
}
