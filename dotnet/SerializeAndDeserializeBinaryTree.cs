#!/usr/bin/env dotnet

// var root = new TreeNode(1);
// root.left = new TreeNode(2);
// root.right = new TreeNode(3);
// root.right.left = new TreeNode(4);
// root.right.right = new TreeNode(5);

// var codec = new Codec();
// var serialised = codec.serialize(root);
// Console.WriteLine(serialised);
// var deserialised = codec.deserialize(serialised);
// var serialisedAgain = codec.serialize(deserialised);
// Console.WriteLine(serialisedAgain);

public class TreeNode
{
    public int val;
    public TreeNode? left;
    public TreeNode? right;
    public TreeNode(int x) { val = x; }
}

public class Codec
{
    // Encodes a tree to a single string.
    public string serialize(TreeNode? root)
    {
        var result = new List<string>();

        void Dfs(TreeNode? node)
        {
            if (node == null)
            {
                result.Add("null");
                return;
            }

            result.Add(node.val.ToString());
            Dfs(node.left);
            Dfs(node.right);
        }

        Dfs(root);

        return string.Join(",", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode? deserialize(string data)
    {
        var values = data.Split(",");
        var index = 0;

        TreeNode? Dfs()
        {
            var value = values[index++];
            if (value == "null")
            {
                return null;
            }

            var node = new TreeNode(int.Parse(value));
            node.left = Dfs();
            node.right = Dfs();
            return node;
        }

        return Dfs();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));