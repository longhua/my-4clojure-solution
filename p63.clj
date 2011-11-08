; Group a Sequence
; Given a function f and a sequence s, write a function which
; returns a map. The keys should be the values of f applied to
; each item in s. The value at each key should be a vector of
; corresponding items in the order they appear in s.
;
(fn [f coll]
  (let [ks (set (map f coll))
        vs (map (fn [k] 
                  (filter #(= k (f %)) coll))
                ks)]
    (reduce (fn [m kv]
              (apply #(assoc m %1 %2) kv))
            {} (map vector ks vs))))
