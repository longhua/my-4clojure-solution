; Graph Connectivity
; Given a graph, determine whether the graph is connected.
; A connected graph is such that a path exists between any
; two given nodes.
;
; -Your function must return true if the graph is connected
;  and false otherwise.
;
;  -You will be given a set of tuples representing the edges
;  of a graph. Each member of a tuple being a vertex/node
;  in the graph.
;
;  -Each edge is undirected (can be traversed either direction).
;
(fn [graph]
  (let [vertices (set (apply concat graph))]
    (letfn [(connected? [v1 v2]
              (or (contains? graph [v1 v2])
                  (contains? graph [v2 v1])))
            (visit [v visited-vertices]
              (conj visited-vertices v))
            (visited? [v visited-vertices]
              (contains? visited-vertices v))
            (dfs [v visited-vertices]
              (let [visited-vertices
                    (visit v visited-vertices)
                    connected-vertices
                    (filter #(connected? v %) vertices)]
                (reduce #(if (visited? %2 %1)
                           %1
                           (dfs %2 %1))
                        visited-vertices connected-vertices)))]
      (if (empty? vertices)
        false
        (= (count vertices)
           (count (dfs (first vertices) #{})))))))
