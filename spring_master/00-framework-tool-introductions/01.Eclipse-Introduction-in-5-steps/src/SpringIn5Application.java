import springDependencyBasic.BinarySearchImpl;


public class SpringIn5Application {
    public static void main(String[] args) {
        BinarySearchImpl binarySearch=new BinarySearchImpl();
        int result=binarySearch.binarySearch(new int[]{12,4,6},3);
        System.out.println(result);

    }
}
