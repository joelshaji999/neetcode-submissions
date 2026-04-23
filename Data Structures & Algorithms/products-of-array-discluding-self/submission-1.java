class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> leftProduct = new ArrayList<Integer>(); 
        List<Integer> rightProduct = new ArrayList<Integer>(); 
        List<Integer> product = new ArrayList<Integer>(); 

        for(int i=0; i<nums.length; i++) {
            if(i==0) {
                leftProduct.add(1);
            }
            else if(i==1){
                leftProduct.add(nums[0]);

            }
            else {
                System.out.println("i"+i);
                System.out.println("val"+leftProduct.get(i-2) * nums[i-1]);

                leftProduct.add(leftProduct.get(i-1) * nums[i-1]);
            }
        System.out.println("leftProduct-"+leftProduct);
        System.out.println("nums-"+Arrays.toString(nums));

        }

        System.out.println(leftProduct);

        for(int i=nums.length-1; i>=0; i--) {
            if(i==nums.length-1) {
                System.out.println("i"+i);

                rightProduct.add(1);
            }
            else if(i==nums.length-2){
                System.out.println("i"+i);

                rightProduct.add(nums[i+1]);
            }
            else{
                System.out.println("i"+i);

                rightProduct.add(rightProduct.get(rightProduct.size()-1) * nums[i+1]);
            }

            System.out.println("rightProduct-"+rightProduct);
            System.out.println("nums-"+Arrays.toString(nums));
        }

        System.out.println(rightProduct);

        for(int i=0; i<nums.length; i++) {
            product.add(leftProduct.get(i) * rightProduct.get(nums.length - i - 1));
        }

        return product.stream().mapToInt(Integer::intValue).toArray();
    }
}  
