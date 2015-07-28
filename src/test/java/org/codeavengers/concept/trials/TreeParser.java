package org.abhishek.concept.trials;

import java.util.ArrayList;
import java.util.List;

public class TreeParser {
    private TreeNode<String> topNode = null;

    public static void main(String[] args) {
        System.out.println("Parsed List contents : " + (new TreeParser()).parse());
    }

    @SuppressWarnings("unchecked")
    private void init() {
        if (null != topNode) {
            return;
        }
        topNode = new TreeNode<String>("1", new TreeNode[] {
            new TreeNode<String>("2", new TreeNode[] {
                new TreeNode<String>("8", new TreeNode[] {
                    new TreeNode<String>("9"),
                    new TreeNode<String>("10", new TreeNode[] {
                        new TreeNode<String>("11")
                    })
                })
            }),
            new TreeNode<String>("3", new TreeNode[] {
                new TreeNode<String>("4"),
                new TreeNode<String>("5", new TreeNode[] {
                    new TreeNode<String>("6")
                })
            }),
            new TreeNode<String>("7")
        });
    }

    private List<TreeParser.TreeNode<String>> parse() {
        /** This list will contain all the parsed nodes. This will be returned finally. */
        List<TreeParser.TreeNode<String>> parsed = new ArrayList<TreeParser.TreeNode<String>>();

        if (this.getRootNode().isLeaf()) {
            parsed.add(this.getRootNode());
        } else {
            /** This list will contain all the unparsed nodes. */
            List<TreeParser.TreeNode<String>> unparsed = new ArrayList<TreeParser.TreeNode<String>>();

            unparsed.add(this.getRootNode());

            while (!unparsed.isEmpty()) {
                /** Get the last item from the unparsed list. */
                int lastUnparsed = unparsed.size() - 1;

                /** Remove it from the unparsed; parse its children. */
                TreeNode<String> parsedNode = unparsed.remove(lastUnparsed);

                /** Store all of its children into the unparsed list. */
                for (TreeNode<String> childNode : parsedNode.getNodes()) {
                    unparsed.add(childNode);
                }

                /** Add the already parsed node to the parsed list. */
                parsed.add(parsedNode);
            }
        }

        return parsed;
    }

    public TreeNode<String> getRootNode() {
        if (null == this.topNode) {
            this.init();
        }
        return this.topNode;
    }

    public class TreeNode<E> {
        private E             nodeName = null;
        private TreeNode<E>[] nodes    = null;

        public TreeNode(E nodeName) {
            super();
            this.nodeName = nodeName;
        }

        public TreeNode(E nodeName, TreeNode<E>[] nodes) {
            super();
            this.nodeName = nodeName;
            this.nodes = nodes;
        }

        public boolean isLeaf() {
            if (0 == this.getLength()) {
                return true;
            }
            return false;
        }

        public boolean isNode() {
            if (0 != this.getLength()) {
                return true;
            }
            return false;
        }

        public int getLength() {
            if (null == this.nodes) {
                return 0;
            }
            return this.nodes.length;
        }

        public E getNodeName() {
            return nodeName;
        }

        @SuppressWarnings("unchecked")
        public TreeNode<E>[] getNodes() {
            if (null == this.nodes) {
                return new TreeNode[0];
            }
            return nodes;
        }

        @Override
        public String toString() {
            return this.nodeName.toString();
        }
    }
}
