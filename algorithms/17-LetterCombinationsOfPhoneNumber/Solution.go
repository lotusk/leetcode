import (
	"fmt"
	"sync"
)

func letterCombinations(digits string) []string {
	phone := map[rune][]string{
		'2': []string{"a", "b", "c"},
		'3': []string{"d", "e", "f"},
		'4': []string{"g", "h", "i"},
		'5': []string{"j", "k", "l"},
		'6': []string{"m", "n", "o"},
		'7': []string{"p", "q", "r", "s"},
		'8': []string{"t", "u", "v"},
		'9': []string{"w", "x", "y", "z"},
	}
	output := []string{}
	p := &output
	var wg sync.WaitGroup
	var backtrack func(string, string)
	var wrapper func(string, string)

	rc := make(chan string)
	backtrack = func(combination string, nextDigits string) {
		defer wg.Done()
		if len(nextDigits) > 0 {
			chars := phone[rune(nextDigits[0])]
			println(chars)
			for _, c := range chars {
				wrapper(combination+c, nextDigits[1:])
			}
		} else {
			// *p = append(*p, combination)
			rc <- combination
		}
	}
	wrapper = func(combination string, nextDigits string) {
		wg.Add(1)
		go backtrack(combination, nextDigits)
	}

	if len(digits) > 0 {
		wrapper("", digits)
	}

	go func() {
		wg.Wait()
		close(rc)
	}()
	for i := range rc {
		*p = append(*p, i)
	}

	return output
}
// func letterCombinations(digits string) []string {
// 	phone := map[rune][]string{
// 		'2': []string{"a", "b", "c"},
// 		'3': []string{"d", "e", "f"},
// 		'4': []string{"g", "h", "i"},
// 		'5': []string{"j", "k", "l"},
// 		'6': []string{"m", "n", "o"},
// 		'7': []string{"p", "q", "r", "s"},
// 		'8': []string{"t", "u", "v"},
// 		'9': []string{"w", "x", "y", "z"},
// 	}
// 	output := []string{}
// 	p := &output
// 	var backtrack func(string, string)
// 	backtrack = func(combination string, nextDigits string) {
// 		if len(nextDigits) > 0 {
// 			chars := phone[rune(nextDigits[0])]
// 			// println(chars)
// 			for _, c := range chars {
// 				backtrack(combination+c, nextDigits[1:])
// 			}
// 		} else {
// 			*p = append(*p, combination)
// 		}
// 	}
// 	if len(digits) > 0 {
// 		backtrack("", digits)
// 	}

// 	return output
// }import (
	"fmt"
	"sync"
)

func letterCombinations(digits string) []string {
	phone := map[rune][]string{
		'2': []string{"a", "b", "c"},
		'3': []string{"d", "e", "f"},
		'4': []string{"g", "h", "i"},
		'5': []string{"j", "k", "l"},
		'6': []string{"m", "n", "o"},
		'7': []string{"p", "q", "r", "s"},
		'8': []string{"t", "u", "v"},
		'9': []string{"w", "x", "y", "z"},
	}
	output := []string{}
	p := &output
	var wg sync.WaitGroup
	var backtrack func(string, string)
	var wrapper func(string, string)

	rc := make(chan string)
	backtrack = func(combination string, nextDigits string) {
		defer wg.Done()
		if len(nextDigits) > 0 {
			chars := phone[rune(nextDigits[0])]
			println(chars)
			for _, c := range chars {
				wrapper(combination+c, nextDigits[1:])
			}
		} else {
			// *p = append(*p, combination)
			rc <- combination
		}
	}
	wrapper = func(combination string, nextDigits string) {
		wg.Add(1)
		go backtrack(combination, nextDigits)
	}

	if len(digits) > 0 {
		wrapper("", digits)
	}

	go func() {
		wg.Wait()
		close(rc)
	}()
	for i := range rc {
		*p = append(*p, i)
	}

	return output
}
// func letterCombinations(digits string) []string {
// 	phone := map[rune][]string{
// 		'2': []string{"a", "b", "c"},
// 		'3': []string{"d", "e", "f"},
// 		'4': []string{"g", "h", "i"},
// 		'5': []string{"j", "k", "l"},
// 		'6': []string{"m", "n", "o"},
// 		'7': []string{"p", "q", "r", "s"},
// 		'8': []string{"t", "u", "v"},
// 		'9': []string{"w", "x", "y", "z"},
// 	}
// 	output := []string{}
// 	p := &output
// 	var backtrack func(string, string)
// 	backtrack = func(combination string, nextDigits string) {
// 		if len(nextDigits) > 0 {
// 			chars := phone[rune(nextDigits[0])]
// 			// println(chars)
// 			for _, c := range chars {
// 				backtrack(combination+c, nextDigits[1:])
// 			}
// 		} else {
// 			*p = append(*p, combination)
// 		}
// 	}
// 	if len(digits) > 0 {
// 		backtrack("", digits)
// 	}

// 	return output
// }
