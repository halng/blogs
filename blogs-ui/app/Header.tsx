"use client";
import { useState, useEffect } from "react";
import Link from "next/link";
import Image from "next/image";
import GithubIcon from "../public/social.png";
type Category = {
  id: number;
  name: string;
  slug: string;
};

const mockCategory = [
  {
    parent: {
      id: 1,
      name: "Library",
      slug: "library",
    },
    child: [
      {
        id: 3,
        name: "Java",
        slug: "java",
      },
      {
        id: 2,
        name: "Python",
        slug: "python",
      },
    ],
  },
  {
    parent: {
      id: 5,
      name: "Blog Post",
      slug: "blog-post",
    },
    child: [
      {
        id: 4,
        name: "Breaking change",
        slug: "breaking-change",
      },
      {
        id: 6,
        name: "Guide",
        slug: "guide",
      },
    ],
  },
];

//parent

const Header = () => {
  const [categories, setCategories] = useState<any>([]);

  useEffect(() => {
    setCategories(mockCategory);
    require("bootstrap/dist/js/bootstrap.bundle.min.js");
    //TODO: get all category from backend
  }, []);

  const getCategoryButton = (dataParent: Category, dataChild: Category[]) => {
    return (
      <div className="dropdown" key={dataParent["slug"]}>
        <span
          className="dropdown"
          role="button"
          id={`dropdownMenuButton_${dataParent["slug"]}`}
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          {dataParent["name"]}
        </span>
        <ul
          className="dropdown-menu"
          aria-labelledby={`dropdownMenuButton_${dataParent["slug"]}`}
        >
          {(dataChild || []).map((item, index) => (
            <li key={item["id"]}>
              <Link
                className="dropdown-item"
                href={`/${dataParent["slug"]}/${item["slug"]}`}
              >
                {item["name"]}
              </Link>
            </li>
          ))}
        </ul>
      </div>
    );
  };

  return (
    <div className="header d-flex justify-content-around align-items-center h4 border-bottom">
      <div className="d-flex justify-content-around align-items-center">
        {/* this is show icon */}
        <div>
          <Image
            alt="github icon"
            src={GithubIcon}
            width={60}
            height={60}
          ></Image>
        </div>
        <div> The Basics Blog</div>
      </div>

      <div className="d-flex w-50 justify-content-evenly">
        <Link href="/">Home</Link>

        {(categories || []).map((item: any) =>
          getCategoryButton(item["parent"], item["child"])
        )}
      </div>
    </div>
  );
};

export default Header;
