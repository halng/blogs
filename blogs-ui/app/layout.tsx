import type { Metadata } from "next";
import { Space_Mono } from "next/font/google";
import Header from "./Header";
import Footer from "./Footer";
import "./app.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { useMemo } from "react";

const inter = Space_Mono({ weight: "400", subsets: ["latin"] });

export const metadata: Metadata = {
  title: "The Basics Blogs",
  description: "Where to learn code from the basic things.",
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  const memoizedComponent = useMemo(() => {
    return <Header />;
  }, []);

  return (
    <html lang="en">
      <body className={inter.className}>
        <div className="container justify-content-center w-100">
          {memoizedComponent }
          {children}
          <Footer />
        </div>
      </body>
    </html>
  );
}
