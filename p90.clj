; Cartesian Product
; Write a function which calculates the Cartesian product of two sets.
;
(fn [s1 s2]
  (set (apply concat
              (map #(map (partial vector %) s2) s1))))
