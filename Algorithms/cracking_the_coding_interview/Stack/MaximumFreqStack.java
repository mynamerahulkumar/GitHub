import java.util.*;

public class MaximumFreqStack {
    Stack<Integer> stack=new Stack<>();
    Map<Integer,Integer> map1=new HashMap<>();
    Map<Integer,ArrayList<Integer>>map2=new HashMap<>();
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>>A){

        int size=A.size();
        ArrayList<Integer> resArrayList=new ArrayList<>();
        for(int i=0;i<size;i++){
            ArrayList<Integer>arrayList=A.get(i);
            if(arrayList.get(0)==1){
                //push
                int k=arrayList.get(1);
                stack.push(k);
                if(map1.containsKey(k)){
                    int v2=map1.get(k);
                    v2++;
                    map1.put(k,v2);
                    if(map2.containsKey(v2)){
                        ArrayList<Integer>arrL=map2.get(v2);
                        arrL.add(k);
                        map2.put(v2,arrL);
                    }
                    else{
                        ArrayList<Integer>arrL=new ArrayList<>();
                        arrL.add(k);
                        map2.put(v2,arrL);
                    }
                }
                else{
                    map1.put(k,1);
                    ArrayList<Integer>arrL=new ArrayList<>();
                    arrL.add(k);
                    map2.put(1,arrL);
                }
                resArrayList.add(-1);
            }
            else if(arrayList.get(0)==2){
                //pop
                int value=getLatestMaxValue();
                if(value==-1){
                    return resArrayList;
                }
                resArrayList.add(value);
                int freK=map1.get(value);
                int frequencyUpdated=freK;
                frequencyUpdated--;
                //update map 1
                if(frequencyUpdated==0){
                    //delete the key from map1
                    map1.remove(freK);
                }
                else{
                    map1.put(value,frequencyUpdated);
                }
                //update map 2
                ArrayList<Integer>arrayList1=map2.get(freK);
                if(arrayList1.size()==1){
                    //delete the key since only one element is present
                    map2.remove(freK);
                }
                else{
                    arrayList1.remove(value);
                    map2.put(freK,arrayList1);
                    if(freK>1){
                        //update in new freqk
                        freK--;
                        if(map2.containsKey(freK)){
                            ArrayList<Integer>arrayList2=map2.get(freK);
                            arrayList2.add(value);
                            map2.put(freK,arrayList2);
                        }
                        else{
                            ArrayList<Integer>arrayList2=new ArrayList<>();
                            arrayList2.add(value);
                            map2.put(freK,arrayList2);
                        }
                    }
                }
            }
        }
        return resArrayList;

    }
    public  int getLatestMaxValue(){
        int maxFrequency=0;
        if(map2.size()<=0){
            return -1;
        }
        for(Map.Entry<Integer,ArrayList<Integer>>element:map2.entrySet()){
            if(element.getKey()>maxFrequency){
                maxFrequency=element.getKey();
            }
        }
        if(maxFrequency<=0){
            return -1;
        }
        ArrayList<Integer>arrayList=map2.get(maxFrequency);
        if(arrayList.size()==1){
            stack.remove(arrayList.get(0));
            return arrayList.get(0);
        }
        else{
            // remove show latest and remove from stack
            int indexStack=-1;
            int len=arrayList.size();
            Iterator iterator=stack.iterator();
            while (iterator.hasNext()){
                 int v= (int) iterator.next();

                 for(int i=0;i<len;i++){
                     if(v==arrayList.get(i)){
                         indexStack=v;
                         break;
                     }
                 }
            }
            if(indexStack!=-1){
                stack.remove(indexStack);
                return indexStack;
            }

        }
        return -1;


    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>arrayList=new ArrayList<>();
        ArrayList<Integer>arr=new ArrayList<>();
        arr.add(1);
        arr.add(4);
        arrayList.add(arr);
        ArrayList<Integer>arr1=new ArrayList<>();
        arr1.add(2);
        arr1.add(0);
        arrayList.add(arr1);
        MaximumFreqStack maximumFreqStack=new MaximumFreqStack();
        maximumFreqStack.solve(arrayList);


    }
}
