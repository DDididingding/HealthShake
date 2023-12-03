/** @type {import('tailwindcss').Config} */
module.exports = {
  // purge: [],
  purge: ["./index.html", "./src/**/*.{vue,js,ts,jsx,tsx}"],
  darkMode: false, // or 'media' or 'class'
  theme: {
    fontFamily: {
      'pretendard': ["Pretendard", "Noto Sans KR", "Segoe UI", "san-serif"]
    },
    extend: {},
  },
  variants: {
    extend: {},
  },
  plugins: [],
};

