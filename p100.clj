; Least Common Multiple
; Write a function which calculates the least common multiple.
; Your function should accept a variable number of positive
; integers or ratios.
;
; Direct solution: try the first number's multiples one bye one.
(fn [& nums]
  (if (empty? nums)
    (throw (Exception. "Not enough arguments"))
    (let [n (first nums)
          others (rest nums)]
      (loop [trial n]
        (if (some #(not (zero? (mod trial %))) others)
          (recur (+ trial n))
          trial)))))

; Use lazy sequence: get the first common multiple
(defn lazy-cm [sorted-sets]
  (let [first-nums (map first sorted-sets)
        max-num (apply max first-nums)]
    (cond (some true? (map empty? sorted-sets)) '()
          (apply = first-nums)
          (lazy-seq
            (cons (first first-nums)
                  (lazy-cm (map rest sorted-sets))))
          :else (lazy-cm (map #((if (= max-num %1) identity rest) %2)
                              first-nums
                              sorted-sets)))))

(defn lcm [& nums]
  (if (empty? nums)
    (throw (Exception. "Not enough arguments"))
    (first (lazy-cm
             (map (fn [n] (iterate #(+ % n) n)) nums)))))
