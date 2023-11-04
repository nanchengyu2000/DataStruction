#include <stdio.h>
#include <stdlib.h>

// 定义线索二叉树节点结构
typedef struct TreeNode {
    int data;
    struct TreeNode *left;
    struct TreeNode *right;
    int isThreaded;  // 用于标记是否是线索
} TreeNode;

// 创建一个新节点
TreeNode* createNode(int data) {
    TreeNode* newNode = (TreeNode*)malloc(sizeof(TreeNode));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    newNode->isThreaded = 0;  // 初始状态不是线索
    return newNode;
}

// 中序遍历线索化二叉树
void inOrderTraversal(TreeNode* root) {
    TreeNode* current = root;
    while (current != NULL) {
        while (current->left != NULL && !current->isThreaded) {
            current = current->left;
        }
        printf("%d ", current->data);
        if (current->isThreaded) {
            current = current->right;
        } else {
            current = current->right;
            while (current != NULL && current->isThreaded) {
                printf("%d ", current->data);
                current = current->right;
            }
        }
    }
}

// 将二叉树线索化
void threadBinaryTree(TreeNode* root, TreeNode** prev) {
    if (root == NULL) return;

    threadBinaryTree(root->left, prev);

    if (*prev != NULL) {
        if ((*prev)->right == NULL) {
            (*prev)->right = root;
            (*prev)->isThreaded = 1;
        }
    }

    if (root->left == NULL) {
        root->left = *prev;
    }

    *prev = root;

    threadBinaryTree(root->right, prev);
}

int main() {
    // 创建一个简单的二叉树
    TreeNode* root = createNode(1);
    root->left = createNode(2);
    root->right = createNode(3);
    root->left->left = createNode(4);
    root->left->right = createNode(5);
    root->right->left = createNode(6);
    root->right->right = createNode(7);

    // 线索化二叉树
    TreeNode* prev = NULL;
    threadBinaryTree(root, &prev);

    // 中序遍历线索化二叉树
    printf("Inorder traversal: ");
    inOrderTraversal(root);

    // 释放内存
    // ... (在实际应用中需要释放节点的内存)

    return 0;
}

