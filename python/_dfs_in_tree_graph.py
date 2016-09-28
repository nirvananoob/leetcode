#
class Solution:
# T is a array representation for a tree  for example : T[x] = y means x connect to y ;
 # T[x] = x means x is the captial.find the distance from x to other nodes.
    def count_dist(self,T):
        distance=[-1]*len(T)
        count=[0]*(len(T)-1)
        for i in range(len(T)):
            if distance[i]<0:
                self.get_dist(T,distance,i)
        for i in range(len(T)):
            if distance[i]>0:
                count[distance[i]-1]+=1
        return count

    def get_dist(self,T,distance,i):
        next=T[i]
        if next==i:
            distance[i]=0
            return 0
        elif distance[next]>0:
            distance[i]=distance[next]+1
            return distance[i]
        else:
            distance[i]=self.get_dist(T,distance,next)+1
            return distance[i]