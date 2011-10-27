; A nil key
; Write a function which, given a key and map, returns true iff the map contains an entry with that key and its value is nil.
;
(fn [k m]
  (and (contains? m k)
       (nil? (m k))))
