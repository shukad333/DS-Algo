package com.hackerrank.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsShortestReach {
    static State state[];
    static LinkedList<Integer> adj[];
    enum State{
        unvisited,visiting,processed;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String s;
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());

        while(T>0)
        {

            String ans="";
            if((s=br.readLine())!=null)
            {
                st=new StringTokenizer(s);
                int V=Integer.parseInt(st.nextToken());
                int E=Integer.parseInt(st.nextToken());
                adj=new LinkedList[V+1];int i=0;
                while(i<E)
                {
                    if((s=br.readLine())!=null)
                    {
                        st=new StringTokenizer(s);
                        int v1=Integer.parseInt(st.nextToken());
                        int v2=Integer.parseInt(st.nextToken());
                        if(adj[v1]==null)
                        {
                            adj[v1]=new LinkedList<Integer>();
                        }
                        adj[v1].add(v2);
                        if(adj[v2]==null)
                        {
                            adj[v2]=new LinkedList<Integer>();
                        }
                        adj[v2].add(v1);
                        i++;
                    }
                }
                int start=Integer.parseInt(br.readLine());
                long arr[]=new long[V+1];
                for(int i1=0;i1<=V;i1++)
                {

                    arr[i1]=-1;

                }
                if(adj[start]!=null)
                    arr=getBFS(start,V,arr);

                for(int i1=1;i1<=V;i1++)
                {
                    if(i1!=start)
                        ans+=arr[i1]+" ";
                }
                out.println(ans.trim());
                T--;
            }

        }
        out.close();
    }

    static long[] getBFS(int start,int V,long[] arr)
    {

        State st[]=new State[V+1];
        for(int i=1;i<=V;i++)
        {
            st[i]=State.unvisited;
        }
        Queue<Integer> list=new LinkedList<>();
        st[start]=State.visiting;
        list.add(start);
        arr[start]=0l;
        while(!list.isEmpty())
        {
            start=(int) list.poll();
            Iterator<Integer> itr=adj[start].iterator();
            while(itr.hasNext())
            {

                int ele=itr.next();
                if(st[ele]==State.unvisited)
                {
                    st[ele]=State.visiting;
                    list.add(ele);
                    arr[ele]=arr[start]+6l;
                }
            }

            st[start]=State.processed;

        }

        return arr;

    }
}