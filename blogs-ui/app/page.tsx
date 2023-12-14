"use client";
import { useEffect, useState } from "react";
import Link from "next/link";

type Blog = {
  date: string;
  name: string;
  slug: string;
  summary: string;
  link: string;
};

const fakeblog = [
  {
    date: "December 01, 2023",
    name: "This is blog changes 1",
    slug: "this-is-blog-changes",
    summary:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto fuga beatae quod non veniam, laboriosam perferendis praesentium rem aliquam nobis earum eveniet enim eum accusantium illo...",
    link: "/java/this-is-blogs-change",
  },
  {
    date: "December 02, 2023",
    name: "This is blog changes 2",
    slug: "this-is-blog-changes",
    summary:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto fuga beatae quod non veniam, laboriosam perferendis praesentium rem aliquam nobis earum eveniet enim eum accusantium illo...",
    link: "/java/this-is-blogs-change",
  },
  {
    date: "December 03, 2023",
    name: "This is blog changes 3",
    slug: "this-is-blog-changes",
    summary:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto fuga beatae quod non veniam, laboriosam perferendis praesentium rem aliquam nobis earum eveniet enim eum accusantium illo...",
    link: "/java/this-is-blogs-change",
  },
  {
    date: "December 04, 2023",
    name: "This is blog changes 4",
    slug: "this-is-blog-changes",
    summary:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto fuga beatae quod non veniam, laboriosam perferendis praesentium rem aliquam nobis earum eveniet enim eum accusantium illo...",
    link: "/java/this-is-blogs-change",
  },
  {
    date: "December 05, 2023",
    name: "This is blog changes 5",
    slug: "this-is-blog-changes",
    summary:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto fuga beatae quod non veniam, laboriosam perferendis praesentium rem aliquam nobis earum eveniet enim eum accusantium illo...",
    link: "/java/this-is-blogs-change",
  },
  {
    date: "December 01, 2023",
    name: "This is blog changes 1",
    slug: "this-is-blog-changes",
    summary:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto fuga beatae quod non veniam, laboriosam perferendis praesentium rem aliquam nobis earum eveniet enim eum accusantium illo...",
    link: "/java/this-is-blogs-change",
  },
  {
    date: "December 02, 2023",
    name: "This is blog changes 2",
    slug: "this-is-blog-changes",
    summary:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto fuga beatae quod non veniam, laboriosam perferendis praesentium rem aliquam nobis earum eveniet enim eum accusantium illo. Voluptatum eius temporibus dolores",
    link: "/java/this-is-blogs-change",
  },
  {
    date: "December 03, 2023",
    name: "This is blog changes 3",
    slug: "this-is-blog-changes",
    summary:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto fuga beatae quod non veniam, laboriosam perferendis praesentium rem aliquam nobis earum eveniet enim eum accusantium illo...",
    link: "/java/this-is-blogs-change",
  },
  {
    date: "December 04, 2023",
    name: "This is blog changes 4",
    slug: "this-is-blog-changes",
    summary:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto fuga beatae quod non veniam, laboriosam perferendis praesentium rem aliquam nobis earum eveniet enim eum accusantium illo....",
    link: "/java/this-is-blogs-change",
  },
  {
    date: "December 05, 2023",
    name: "This is blog changes 5",
    slug: "this-is-blog-changes",
    summary:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto fuga beatae quod non veniam, laboriosam perferendis praesentium rem aliquam nobis earum eveniet enim eum accusantium illo...",
    link: "/java/this-is-blogs-change",
  },
];

export default function Home() {
  const [blogs, setBlogs] = useState<Blog[]>([]);

  useEffect(() => {
    setBlogs(fakeblog);
  }, []);

  return (
    <div className="main-page py-5">
      <div className="text-center pb-3">
        <div className="h3">Latest Updates</div>
        <div className="h5">All the latest blogs, straight from the team.</div>
      </div>
      <div>
        {(blogs || []).map((item) => (
          <div key={item.slug} className="d-flex w-100 pb-3">
            <div className="w-25">{item.date}</div>
            <div className="w-75">
              <div className="h5">{item.name}</div>
              <div>{item.summary}</div>
              <div>
                <Link href={item.link}>
                  <p className="font-italic">Read more...</p>
                </Link>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
