package test;

import commom.TreeNode;

public class ThreadLocalTest {
//	static class MyThread extends Thread {
//		private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//
//		@Override
//		public void run() {
//			super.run();
//			for (int i = 0; i < 3; i++) {
//				threadLocal.set(i);
//				System.out.println(getName() + " threadLocal.get() = " + threadLocal.get());
//			}
//		}
//	}
public static TreeNode buildTree(int[] inorder, int[] postorder) {
	return buildSonTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
}
	public static TreeNode buildSonTree(int[] inorder, int[] postorder, int inleft, int inright, int postleft, int postright){
		if(inleft>inright||postleft>postright) return null;
		TreeNode node = new TreeNode(postorder[postright]);
		if(inleft == inright) return node;
		int inordersplit = inleft;
		while(inorder[inordersplit]!=postorder[postright]){
			inordersplit++;
		}
		node.left = buildSonTree(inorder,postorder,inleft,inordersplit-1,postleft,postleft+inordersplit-inleft-1);
		node.right = buildSonTree(inorder,postorder,inordersplit+1,inright,postleft+inordersplit-inleft+1,postright-1);
		return node;
	}
	public static void main(String[] args) throws InterruptedException {
		int[] nums1 = new int[]{9,3,15,20,7};
		int[] nums2 = new int[]{9,15,7,20,3};
		buildTree(nums1,nums2);
//		MyThread myThreadA = new MyThread();
//		myThreadA.setName("ThreadA");
//
//		MyThread myThreadB = new MyThread();
//		myThreadB.setName("ThreadB");
//
//		myThreadA.start();
//		myThreadB.start();
//		ThreadLocal<Integer> local1 = new ThreadLocal<>();
//		ThreadLocal<Integer> local2 = new ThreadLocal<>();
//		local1.set(1);
//		local1.get();
//		local2.set(2);



	}
}
