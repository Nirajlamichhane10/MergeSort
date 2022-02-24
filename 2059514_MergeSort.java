  
import java.util.*;
public class MergeSort {
    ArrayList list=new ArrayList();
    ArrayList getinput(ArrayList<Integer>al){
        Scanner Nir= new Scanner(System.in);  // Using Scanner class.
        System.out.print("How many number do you want in list for Mergesort: ");
        int t= Nir.nextInt();
        int y=0;
        while (y<t){
            System.out.print("enter a number which you want to add: ");
            int number=Nir.nextInt();
            al.add(number);
            y++;
        }
        return al;
    }
    ArrayList merge(ArrayList<Integer>a,ArrayList<Integer>b){  //  Using toArrayList 
        ArrayList naya= new ArrayList();
        int left_index=0;
        int right_index=0;
        while (left_index<a.size()&right_index<b.size()){   
            if (a.get(left_index)<b.get(right_index)){
                naya.add(a.get(left_index));
                left_index++;
            }
            else{
                naya.add(b.get(right_index));
                right_index++;
            }
        }
        while(left_index<a.size()){
            naya.add(a.get(left_index));
            left_index++;
        }
        while(right_index<b.size()){
            naya.add(b.get(right_index));
            right_index++;
        }
        return naya;
    }
    static void output(ArrayList<Integer>al){
        for (int x=0;x<al.size();x++){
            System.out.print(al.get(x)+" ");
        }
    }
    ArrayList sort(ArrayList<Integer>al,int beg,int mid,int end){
        ArrayList a= new ArrayList();
        ArrayList b=new ArrayList();
        while(beg<mid){
            a.add(al.get(beg));
            beg++;
        }
        while(mid<end){
            b.add(al.get(mid));
            mid++;
        }
        if (a.size() != 1){
            int a_beg=0;
            int a_end=a.size();
            int a_mid;
            if (a_end%2==0){
                a_mid=a_end/2;
            }
            else {
                a_mid=(a_end+1)/2;
            }
            sort(a,a_beg,a_mid,a_end);
        }
        if (b.size() !=1){
            int b_beg=0;
            int b_end=b.size();
            int b_mid;
            if (b_end%2==0){
                b_mid=b_end/2;
            }
            else {
                b_mid=(b_end+1)/2;
            }
            sort(b,b_beg,b_mid,b_end);
        }
        if (a.size()!=1 & b.size()==1){
            ArrayList xyz=merge(list,b);
            list=xyz;
        }
        if (a.size()==1 & b.size()==1){
            ArrayList abc=merge(a,b);
            ArrayList xyz=merge(abc,list);
            list=xyz;
        }
        return list;
    }
    public static void main(String[] args){
        ArrayList al= new ArrayList();
        MergeSort obj=new MergeSort();
        ArrayList list=obj.getinput(al);
        System.out.print("This is the  unsortedList: ");
        output(list);
        int end=list.size();
        int beg=0;
        int mid;
        if (end%2==0){
            mid=end/2;
        }
        else{
            mid=(end+1)/2;
        }
        ArrayList final_list=obj.sort(list,beg,mid,end);
        System.out.println("");
        System.out.print("This is the sortedlist: ");
        output(final_list);
    }


}





