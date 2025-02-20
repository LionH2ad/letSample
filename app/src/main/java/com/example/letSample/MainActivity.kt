package com.example.letSample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.letSample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 뷰바인딩 변수
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 뷰바인딩 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 각 버튼의 클릭 이벤트를 해당 함수로 연결
        binding.btnProblem1.setOnClickListener { solveProblem1() }
        binding.btnProblem2.setOnClickListener { solveProblem2() }
        binding.btnProblem3.setOnClickListener { solveProblem3() }
        binding.btnProblem4.setOnClickListener { solveProblem4() }
        binding.btnProblem5.setOnClickListener { solveProblem5() }
    }

    /**
     * 문제 1: 문자열 길이 계산
     *
     * 의도:
     * - 사용자가 EditText에 입력한 문자열을 let으로 캡쳐하여, 해당 문자열의 길이를 계산.
     * - 계산 결과를 "입력한 글자 수는 X 자입니다."라는 메시지로 토스트 출력.
     *
     * 기대 결과:
     * - 예: "Hello" 입력 시 -> "입력한 글자 수는 5 자입니다." 토스트 메시지 출력.
     */
    private fun solveProblem1() {
        binding.editText.text.toString().let { input ->
            val length = input.length
            Toast.makeText(this, "입력한 글자 수는 $length 자입니다.", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 문제 2: 문자열 트림 (원본 vs 결과 비교)
     *
     * 의도:
     * - 사용자가 EditText에 입력한 문자열(앞뒤 공백 포함)을 let으로 캡쳐.
     * - 캡쳐한 문자열을 trim()하여 앞뒤 공백을 제거한 후,
     *   원본과 트림 결과를 TextView에 한 번에 출력.
     *
     * 기대 결과:
     * - 예: "  Android  " 입력 시 ->
     *   결과 TextView에
     *   원본: '  Android  '
     *   트림 후: 'Android'
     *   가 출력됨.
     */
    private fun solveProblem2() {
        binding.editText.text.toString().let { original ->
            val trimmed = original.trim()
            binding.textView.text = "원본: '$original'\n트림 후: '$trimmed'"
        }
    }

    /**
     * 문제 3: 숫자 제곱 계산
     *
     * 의도:
     * - 사용자가 EditText에 입력한 숫자 문자열을 정수로 변환하고 let으로 캡쳐.
     * - 캡쳐한 숫자의 제곱을 계산한 후, "입력된 숫자의 제곱은 Y 입니다." 메시지로 결과 출력.
     *
     * 기대 결과:
     * - 예: "4" 입력 시 -> "입력된 숫자의 제곱은 16 입니다."가 출력됨.
     */
    private fun solveProblem3() {
        binding.editText.text.toString().toIntOrNull()?.let { number ->
            val square = number * number
            binding.textView.text = "입력된 숫자의 제곱은 $square 입니다."
        } ?: run {
            binding.textView.text = "유효한 숫자를 입력해주세요."
        }
    }

    /**
     * 문제 4: 버튼 텍스트 뒤집기
     *
     * 의도:
     * - 현재 버튼의 텍스트(기본 "Button")를 let으로 캡쳐하여 reversed()를 통해 뒤집음.
     * - 뒤집은 결과를 버튼 텍스트와 결과 TextView에 출력하여 let을 통한 문자열 변환을 학습.
     *
     * 기대 결과:
     * - 예: "Button" -> "nottuB"로 변경되고,
     *   결과 TextView에 "버튼 텍스트가 뒤집혔습니다: nottuB"가 출력됨.
     */
    private fun solveProblem4() {
        binding.btnProblem4.text.toString().let { currentText ->
            val reversed = currentText.reversed()
            binding.btnProblem4.text = reversed
            binding.textView.text = "버튼 텍스트가 뒤집혔습니다: $reversed"
        }
    }

    /**
     * 문제 5: 숫자에 10 더하기
     *
     * 의도:
     * - 사용자가 EditText에 입력한 숫자 문자열을 정수로 변환하여 let으로 캡쳐.
     * - 캡쳐한 숫자에 10을 더한 후, "최종 결과: Z" 메시지로 TextView에 출력.
     *
     * 기대 결과:
     * - 예: "5" 입력 시 -> "최종 결과: 15"가 출력됨.
     */
    private fun solveProblem5() {
        binding.editText.text.toString().toIntOrNull()?.let { number ->
            val result = number + 10
            binding.textView.text = "최종 결과: $result"
        } ?: run {
            binding.textView.text = "유효한 숫자를 입력해주세요."
        }
    }
}
