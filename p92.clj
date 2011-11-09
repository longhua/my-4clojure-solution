; Read Roman numerals
; Roman numerals are easy to recognize, but not everyone
; knows all the rules necessary to work with them. Write
; a function to parse a Roman-numeral string and return
; the number it represents.
;
(fn read-roman-numeral [nums]
  (let [values {\I 1
                \V 5
                \X 10
                \L 50
                \C 100
                \D 500
                \M 1000}]
    (loop [nums nums
           prev -1
           part-result 0
           result 0]
      (if (empty? nums)
        (+ result part-result)
        (let [curr (values (first nums))
              rest-nums (rest nums)]
          (cond (= prev -1)
                (recur rest-nums
                       curr
                       curr
                       result)
                (= prev curr)
                (recur rest-nums
                       curr
                       (+ part-result curr)
                       result)
                (< prev curr)
                (recur rest-nums
                       -1
                       0
                       (+ result
                          (- curr part-result)))
                (> prev curr)
                (recur rest-nums
                       curr
                       curr
                       (+ result part-result))))))))
