#include <stdio.h>
#include <stdlib.h>

// ���������������ڵ�ṹ
typedef struct TreeNode {
    int data;
    struct TreeNode *left;
    struct TreeNode *right;
    int isThreaded;  // ���ڱ���Ƿ�������
} TreeNode;

// ����һ���½ڵ�
TreeNode* createNode(int data) {
    TreeNode* newNode = (TreeNode*)malloc(sizeof(TreeNode));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    newNode->isThreaded = 0;  // ��ʼ״̬��������
    return newNode;
}

// �������������������
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

// ��������������
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
    // ����һ���򵥵Ķ�����
    TreeNode* root = createNode(1);
    root->left = createNode(2);
    root->right = createNode(3);
    root->left->left = createNode(4);
    root->left->right = createNode(5);
    root->right->left = createNode(6);
    root->right->right = createNode(7);

    // ������������
    TreeNode* prev = NULL;
    threadBinaryTree(root, &prev);

    // �������������������
    printf("Inorder traversal: ");
    inOrderTraversal(root);

    // �ͷ��ڴ�
    // ... (��ʵ��Ӧ������Ҫ�ͷŽڵ���ڴ�)

    return 0;
}

