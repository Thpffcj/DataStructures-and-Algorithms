//
// Created by Thpffcj on 2017/8/16.
//

#ifndef DATASTRUCTURESANDALGORITHMS_UNIONFIND2_H
#define DATASTRUCTURESANDALGORITHMS_UNIONFIND2_H

#include <cassert>
#include <c++/array>

using namespace std;

namespace UF2{

    class UnionFind{

    private:
        int* parent;
        int count;

    public:
        UnionFind(int count){
            parent = new int[count];
            this->count = count;
            for( int i = 0 ; i < count ; i ++ )
                parent[i] = i;
        }

        ~UnionFind(){
            delete[] parent;
        }

        int find(int p){
            assert( p >= 0 && p < count );
            while( p != parent[p] )
                p = parent[p];
            return p;
        }

        bool isConnected( int p , int q ){
            return find(p) == find(q);
        }

        void unionElements(int p, int q){

            int pRoot = find(p);
            int qRoot = find(q);

            if( pRoot == qRoot )
                return;

            parent[pRoot] = qRoot;
        }
    };
}

#endif //DATASTRUCTURESANDALGORITHMS_UNIONFIND2_H
