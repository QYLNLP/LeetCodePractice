package leetCode_bianry;

/**
 * 序列化和反序列化二叉树
 * 
 * @author qyl
 *
 */
public class Solution449
{
	// Encodes a tree to a single string.
	public static String serialize(TreeNode root)
	{
		StringBuilder sb = new StringBuilder();
		serializeCode(root,sb);
		return sb.toString();

	}
	private static void serializeCode(TreeNode root,StringBuilder sb) {
		if(root==null) {
			return;
		}
		
		sb.append(root.val+"#");
		serializeCode(root.left,sb);
		serializeCode(root.right,sb);
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data)
	{
		if(data==null||data.length()==0) {
			System.out.println("进入反编译");
			return null;
		}		
		String[] str =data.split("#");
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
		TreeNode root = new TreeNode(Integer.parseInt(str[0]));
		for(int i=1;i<str.length;i++) {
			insert(root,Integer.parseInt(str[i]));
		}
		return root;

	}
	
	/**
	 * 在反序列化时逐个插入
	 * @param node
	 * @param value
	 */
	private static void insert(TreeNode node,int value) {
		
		if(value<=node.val) {
			if(node.left!=null) {
				insert(node.left,value);
			}else {
				node.left=new TreeNode(value);
			}
		}else {
			if(node.right!=null) {
				insert(node.right,value);
			}else {
				node.right=new TreeNode(value);
			}
		}
	}
}
