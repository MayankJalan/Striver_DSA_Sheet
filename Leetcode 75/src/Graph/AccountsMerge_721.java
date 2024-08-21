package Graph;

import java.util.*;
import java.util.stream.IntStream;

public class AccountsMerge_721 {
    class Disjoint{
        int parent[];
        int size[];
        public Disjoint(int n) {
            parent=new int[n];
            size=new int[n];
            IntStream.range(0,n).forEach(i -> {
                parent[i]=i;
                size[i]=1;
            });
        }

        public int findParent(int node){
            if(parent[node]==node){
                return node;
            }
            int uniParent=findParent(parent[node]);
            parent[node]=uniParent;
            return uniParent;
        }

        public void unionBySize(int u, int v){
            int uniU=findParent(u);
            int uniV=findParent(v);
            if(uniV == uniV){
                return;
            }
            if(size[uniU] >= size[uniV]){
                size[uniU] += size[uniV];
                parent[uniV]=uniU;
            }
            else {
                size[uniV] += size[uniU];
                parent[uniU]=uniV;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        Disjoint ds=new Disjoint(n);


        HashMap<String , Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    ds.unionBySize(map.get(mail), i);
                }
                else {
                    map.put(mail,i);
                }
            }
        }

        ArrayList<String> arr [] =new ArrayList[n];
        for(int i =0;i<n;i++){
            arr[i]=new ArrayList<>();
        }
        for(Map.Entry<String,Integer> ent : map.entrySet()){
            String mail=ent.getKey();
            int index=ds.findParent(ent.getValue());

            arr[index].add(mail);
        }
        List<List<String>> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(arr[i].size()==0){
                continue;
            }
            else {
                ArrayList<String> temp=new ArrayList<>(arr[i]);
                Collections.sort(temp);
                temp.add(0, accounts.get(i).get(0));
                ans.add(temp);
            }
        }
        return ans;





    }
}
